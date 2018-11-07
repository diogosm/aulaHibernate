/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aula1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author diogo
 */
public class Main {
    
    public static void main(String[] args){
        System.out.println("iniciando");
        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        /*
            Faz algumas adições na base
        */
        Contato contato1 = new Contato();
        
        contato1.setNome("Diogo Soares");
        contato1.setEmail("diogosoaresm@ufam.edu.br");
        contato1.setEndereco("rua bolinha e bolinha");
        Calendar aux = GregorianCalendar.getInstance();
        aux.set(1990, Calendar.MARCH, 23);
        contato1.setDatanascimento( aux );
        
        Contato contato2 = new Contato();
        
        contato2.setNome("Lionel Messi");
        contato2.setEmail("messi@gmail.com");
        contato2.setEndereco("barcelona");
        aux = GregorianCalendar.getInstance();
        aux.set(1988, Calendar.JANUARY, 01);
        contato2.setDatanascimento( aux );
        
        adicionar(session, contato1);
        adicionar(session, contato2);
        
        lista(session);
        
        remover(session, "Diogo Soares");
        
        System.out.println("Resultado após remoção...");
        
        lista(session);
        
        adicionar(session, contato1);
        atualizar(session, "Lionel Messi", "messi_oficial@gmail.com", "barcelona", aux);
        
        System.out.println("Resultado após atualizações...");
        
        lista(session);
        
        session.close();
    }
    
    public static void adicionar(Session session, Contato contato){
        session.beginTransaction();
        session.save(contato);
        session.getTransaction().commit();
    }
    
    public static void remover(Session session, String nome){
        Query q = session.createQuery("select ans from Contato ans where ans.nome = '" + nome + "'");
        
        List resultado = q.list();
        
        for(Iterator it = resultado.iterator(); it.hasNext();){
            Contato contato = (Contato) it.next();
            
            System.out.println("id do contato... " + contato.getId());
            
            Contato praExcluir = (Contato) session.get(Contato.class, contato.getId());
            
            session.beginTransaction();
            session.delete(praExcluir);
            session.getTransaction().commit();
        }
    }
    
    public static void atualizar(Session session, String nome, String email, String endereco, Calendar dataNascimento){
        Query q = session.createQuery("select ans from Contato ans where ans.nome = '" + nome + "'");
        
        List resultado = q.list();
        
        for(Iterator it = resultado.iterator(); it.hasNext();){
            Contato contato = (Contato) it.next();
            
            Contato praAtualizar = (Contato) session.get(Contato.class, contato.getId());
            praAtualizar.setEmail(email);
            praAtualizar.setEndereco(endereco);
            praAtualizar.setDatanascimento(dataNascimento);
            
            session.beginTransaction();
            session.update(praAtualizar);
            session.getTransaction().commit();
        }
    }
    
    public static void lista(Session session){
        Query q = session.createQuery("select ans from Contato ans");
        
        List resultado = q.list();
        
        System.out.println("Contatos:");
        
        for (Iterator it = resultado.iterator(); it.hasNext();) {
            Contato contato = (Contato) it.next();
            System.out.println("Nome: \t" + contato.getNome());
            System.out.println("email: \t" + contato.getEmail());
            System.out.println("endereco: \t" + contato.getEndereco());
            
            SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
            String dataNas = formatoData.format(contato.getDatanascimento().getTime());
            System.out.println("Data de nascimento: \t" + dataNas);
            
            System.out.println();
        }
    }
    
}

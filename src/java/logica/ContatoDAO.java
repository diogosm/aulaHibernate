/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author diogo
 */
public class ContatoDAO {

    private final Connection connection;

    public ContatoDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(ContatoOld contato) {

        Connection con
                = new ConnectionFactory().getConnection();
        String sql = "insert into contatos "
                + "(nome,email,endereco,dataNascimento)"
                + "values(?,?,?,?)";
        try {
            PreparedStatement stmt
                    = con.prepareStatement(sql);

            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getEmail());
            stmt.setString(3, contato.getEndereco());
            stmt.setDate(4,
                    new Date(
                            contato.getDataCad().getTimeInMillis()));

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ContatoOld> getLista() {
        try {
            List<ContatoOld> contatos = new ArrayList<ContatoOld>();
            PreparedStatement stmt
                    = this.connection.prepareStatement(""
                            + "select * from contatos");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ContatoOld contato = new ContatoOld();
                contato.setId(rs.getInt("id"));
                contato.setNome(rs.getString("nome"));
                contato.setEmail(rs.getString("email"));
                contato.setEndereco(rs.getString("endereco"));
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("datanascimento"));
                contato.setDataCad(data);
                contatos.add(contato);
            }
            rs.close();
            stmt.close();
            return contatos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void altera(ContatoOld contato) {
        String sql = "update contatos set nome=?, email=?,"
                + "endereco=?, dataNascimento=? where id=?";
        try {
            PreparedStatement stmt
                    = connection.prepareStatement(sql);
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getEmail());
            stmt.setString(3, contato.getEndereco());
            stmt.setDate(4, new Date(contato.getDataCad().getTimeInMillis()));
            stmt.setLong(5, contato.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remove(ContatoOld contato) {
        System.out.println(contato.getId());
        try {
            PreparedStatement stmt
                    = connection.prepareStatement("delete from contatos where id=?");
            stmt.setInt(1, contato.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

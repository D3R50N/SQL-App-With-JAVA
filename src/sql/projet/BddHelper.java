/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql.projet;

import java.sql.*;

public class BddHelper {

    static String nomPilote = "com.mysql.cj.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/eneamjava";
    static String userId = "root";
    static String password = "";

    static Connection con;

    public static void initDriver() {
        try {
            Class.forName(nomPilote);
            System.out.println("Pilote changé");
        } catch (ClassNotFoundException e) {
            System.err.println("Erreur de chargement du driver : " + e);
        }
    }

    public static void initDB() {
        try {
            con
                    = DriverManager.getConnection(url, userId, password);
            System.out.println("Bdd initialisé");

        } catch (SQLException sqle) {
            System.err.println("Erreur lors de la connexion : "
                    + sqle);
        }

    }

    public static boolean insertUE(UE ue) {
        String table = "ue (id, intitule, credit, semestre) ";
        String query = "INSERT INTO "
                + table
                + " VALUES (NULL, '"
                + ue.getIntitule() + "', '"
                + ue.getCredit() + "', '"
                + ue.getSemestre() + "')";
        try {
            Statement st = con.createStatement();
            int rs = st.executeUpdate(query);
            System.out.println(query);
        } catch (SQLException sqle) {
            System.err.println("Erreur lors de l'insertion : "
                    + sqle);
            return false;
        }
        return true;
    }

    public static boolean insertEtudiant(Etudiant etu) {
        String etudiantTable = "etudiant (id, matricule, nom, prenom, telephone, sexe, datenais) ";
        String query = "INSERT INTO "
                + etudiantTable
                + " VALUES (NULL, '"
                + etu.getMatricule() + "', '"
                + etu.getNom() + "', '"
                + etu.getPrenom() + "', '"
                + etu.getTelephone() + "', '"
                + etu.getSexe() + "', '"
                + etu.getDatenaiss().toString() + "')";
        try {
            Statement st = con.createStatement();
            int rs = st.executeUpdate(query);
            System.out.println(query);
        } catch (SQLException sqle) {
            System.err.println("Erreur lors de l'insertion : "
                    + sqle);
            return false;
        }
        return true;
    }

    public static Etudiant[] selectallEtudiant() {
        int nb_rows = 0;
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT count(*) FROM etudiant");
            if (rs.next()) {
                nb_rows = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération de nb rows: "
                    + e);
        }

        String etudiantTable = "etudiant";
        String query = "SELECT * FROM " + etudiantTable;
        Etudiant[] list = new Etudiant[nb_rows];
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            //  System.out.println(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            int column_count = rsmd.getColumnCount();
            while (rs.next()) {
                Etudiant etu = new Etudiant();
                for (int i = 1; i <= column_count; i++) {
                    //    System.out.print(rs.getObject(i) + "\t");
                    switch (i) {
                        case 1:
                            continue;
                        case 2:
                            etu.setMatricule(rs.getInt(i));
                            break;
                        case 3:
                            etu.setNom(rs.getString(i));
                            break;
                        case 4:
                            etu.setPrenom(rs.getString(i));

                            break;
                        case 5:
                            etu.setTelephone(rs.getInt(i));
                            break;
                        case 6:
                            etu.setSexe(rs.getString(i));
                            break;
                        case 7:
                            etu.setDatenaiss(rs.getDate(i));
                            break;
                    }

                }
                //  System.out.println();
                list[rs.getRow() - 1] = etu;
            }
            return list;
        } catch (SQLException sqle) {
            System.err.println("Erreur lors de la sélection : "
                    + sqle);
        }
        return null;
    }

    public static UE[] selectallUE() {
        int nb_rows = 0;
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT count(*) FROM ue");
            if (rs.next()) {
                nb_rows = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération de nb rows: "
                    + e);
        }

        String table = "ue";
        String query = "SELECT * FROM " + table;
        UE[] list = new UE[nb_rows];
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            //  System.out.println(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            int column_count = rsmd.getColumnCount();
            while (rs.next()) {
                UE current = new UE();
                for (int i = 1; i <= column_count; i++) {
                    //    System.out.print(rs.getObject(i) + "\t");
                    switch (i) {
                        case 1:
                            continue;
                        case 2:
                            current.setIntitule(rs.getString(i));
                            break;
                        case 3:
                            current.setCredit(rs.getInt(i));
                            break;
                        case 4:
                            current.setSemestre(rs.getInt(i));
                            break;
                    }

                }
                //  System.out.println();
                list[rs.getRow() - 1] = current;
            }
            return list;
        } catch (SQLException sqle) {
            System.err.println("Erreur lors de la sélection : "
                    + sqle);
        }
        return null;
    }
}

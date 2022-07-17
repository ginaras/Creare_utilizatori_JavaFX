package com.creare.creare_utilizatori_2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class baza implements Initializable {


    // CJ
    public static String CREATEUSERNAME = "CREATE USER IF NOT EXISTS cJudeteanUser@localhost identified by 'C12Jude45Tean' ";
    public static String USERr = "root";
    public static String PASSWORDr = "root";

    public static String USER = "cJudeteanUser";
    public static String PASSWORD = "C12Jude45Tean";

    public static String URLr = String.format("jdbc:mariadb://localhost:3307/mysql");
    public static String URL = String.format("jdbc:mariadb://localhost:3307/cJudetean");

    public static String selectUser = "SELECT USER cJudetean FROM mysql.user";
    public static final String CREATE_DATABASE = "CREATE DATABASE IF NOT EXISTS cJudetean ";
    public static final String USE_DATABASE = "USE cJudetean";
    public static final String GRANT_aLL_OPTION = "GRANT ALL PRIVILEGES ON cJudeteanUser.* to cJudeteanUser@localhost IDENTIFIED BY 'C12Jude45Tean' WITH GRANT OPTION";


    // Basarabi
//    public static String CREATEUSERNAME = "CREATE USER IF NOT EXISTS invPrimBasaRabI@86.105.32.16 identified by 'prima21sara2iLoG' ";
//    public static String USERr=  "root";
//    public static String PASSWORDr= "PasDeTrecere@server1Gyn22";
//    public static String URLr = String.format( "jdbc:mariadb://86.105.32.16:3367/mysql" );
//    public static String selectUser ="SELECT USER invPrimBasaRabI FROM mysql.user";
//    public static final String CREATE_DATABASE ="CREATE DATABASE IF NOT EXISTS primariaMurfatlar ";

//    public static String USER=  "invPrimBasaRabI";
//    public static String PASSWORD=  "prima21sara2iLoG";
//    public static String URL = String.format( "jdbc:mariadb://86.105.32.16:3367/primariaMurfatlar" );
//    public static String URLbackup = String.format( "jdbc:mariadb://86.105.32.16:3367/primariaMurfatlarDBbackup" );
//    public static final String USE_DATABASE = "USE primariaMurfatlar";
//    public static final String GRANT_aLL_OPTION = "GRANT ALL PRIVILEGES ON primariaMurfatlar.* to invPrimBasaRabI@86.105.32.16 IDENTIFIED BY 'prima21sara2iLoG' WITH GRANT OPTION";

    /// acasa - maria
//    public static String CREATEUSERNAME = "CREATE USER IF NOT EXISTS 'investitii'@'localhost' identified by 'pas@inv2gyn' ";
//    public static String USERr=  "root";
//    public static String USER=  "root";
//    public static String PASSWORDr=  "root";
//    public static String PASSWORD=  "root";
//    public static String URLinvsys = String.format( "jdbc:mariadb://localhost:3307/mysql" );
//    public static String URL = String.format( "jdbc:mariadb://localhost:3307/invDB" );
//    public static String URLr = String.format( "jdbc:mariadb://localhost:3307/mysql" );
//    public static String URLbackup = String.format( "jdbc:mariadb://localhost:3307/invDBbackup" );
//    public static final String USE_DATABASE = "USE invDB";


    //MUNCA
//    public static String USER=  "investitii";
//    public static String PASSWORD=  "pas@inv.2Gyn";//-maria
//    public static String URLinvsys = String.format( "jdbc:mariadb://10.59.4.8:3306/mysql" );
//    public static String URLbackup = String.format( "jdbc:mariadb://10.59.4.8:3306/invDBbackup" );
//    public static String URL = String.format( "jdbc:mariadb://10.59.4.8/invDB" );
//    public static final String USE_DATABASE = "USE invDB";


    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS invTBL (nrCrt INT(6) AUTO_INCREMENT PRIMARY KEY, furnizor CHAR(100) not null, nrFactura char(40) , dataFacturii DATE, dataContabilizarii DATE, valoare varCHAR(20), nrPIF CHAR (50), dataPIF DATE, descriereFactura varChar(210), valInitiala varCHAR(20), tva varCHAR(20), valTot varCHAR(20), contract CHAR(25), contInv CHAR(20), contFz VARCHAR(20), nrProiect CHAR(20), deviz CHAR(20), org CHAR(10), respProiect CHAR(50), atas MEDIUMBLOB, rezerva2 VARCHAR (50)) ";
    public static final String CREATE_TABLE_BUGET_ORG = "CREATE TABLE IF NOT EXISTS bugetORG (nrCrt INT(5) AUTO_INCREMENT PRIMARY KEY, org CHAR(10) NOT NULL,denumireOrg CHAR(70), anulBugetar CHAR(4), valInitiala varChar(20), valRectificata CHAR(20), valFinala CHAR(20), inactiv VARCHAR (3),rezerva1 VARCHAR (50))";
    public static final String CREATE_TABLE_BUGET_PROJ = "CREATE TABLE IF NOT EXISTS bugetPROJ (nrCrt INT(5) AUTO_INCREMENT PRIMARY KEY, nrProiect CHAR(20), denProiect CHAR(200), startProiect DATE, valInitiala VARCHAR(20), valRectificare VARCHAR(20) NOT NULL, valFinala VARCHAR(20), respProiect VARCHAR(50), nrCofinantare VARCHAR (20), inactiv VARCHAR (3), rezerva1 VARCHAR (50))";
    public static final String CREATE_TABLE_BUGET_CONTRACT = "CREATE TABLE IF NOT EXISTS bugetCONTRACT (nrCrt INT(5) AUTO_INCREMENT PRIMARY KEY, furnizor CHAR(100), CUIfurnizor CHAR(14), adresa CHAR (100), nrContract CHAR(25),dataContract DATE,valInitiala VARCHAR(20), valRectificare VARCHAR(20) NOT NULL, valFinala VARCHAR(20), inactiv VARCHAR (3), rezerva1 VARCHAR (50) )";
    public static final String CREATE_TABLE_RAPORT_PIF = "CREATE TABLE IF NOT EXISTS raportPIF (nrCrt INT(3),org VARCHAR(10), nrProiect CHAR(20), denProiect CHAR(200), nrPIF VARCHAR (50), dataPIF DATE, valPIF VARCHAR(20), responsabilProiect VARCHAR(50),rezerva1 VARCHAR (50))";
    public static final String CREATE_TABLE_RESP_PRIVILEGE = "CREATE TABLE IF NOT EXISTS respPrivilege (nrCrt INT (3) AUTO_INCREMENT PRIMARY KEY, respProiect VARCHAR(50), macNr VARCHAR(17), adminu CHAR(10), sex CHAR (1), inactiv VARCHAR (3), rezerva1 VARCHAR (50))";
    public static final String CREATE_TABLE_PLATI = "CREATE TABLE IF NOT EXISTS plati (nrCrtPlati INT(5) AUTO_INCREMENT PRIMARY KEY, orgPlati VARCHAR (5), furnizorPlati VARCHAR(100), nrFactPlati VARCHAR(40), dataFactPlati DATE, opPlata VARCHAR(20), valPlatita VARCHAR (20), dataPlatii DATE, nrProiectPlati VARCHAR(20), rezervaPlati VARCHAR (50),rezerva1 VARCHAR (50))";
    public static final String CREATE_CONTINV_DESCRIBE = "CREATE TABLE IF NOT EXISTS contInvDescribe ( contInvD CHAR (20) PRIMARY KEY, describeCont VARCHAR(40), rezerva1 VARCHAR (50))";
    public static final String CREATE_CONT_FZ = "CREATE TABLE IF NOT EXISTS contFurnizor (nrCrt INT(3) AUTO_INCREMENT PRIMARY KEY, simbolCont VARCHAR (10), denContFurnizor VARCHAR (50), inactiv VARCHAR (3), rezerva1 VARCHAR (50))";
    public static final String CREATE_DEVIZE = "CREATE TABLE IF NOT EXISTS devizeLucrari (simbolDeviz VARCHAR(15), denumireDeviz VARCHAR(70), rezerva1 VARCHAR(50)) ";
    public static final String CREATE_TABLE_ANI = "CREATE TABLE IF NOT EXISTS ani (nrCrt INT(2) AUTO_INCREMENT PRIMARY KEY, an INT (4), rezerva1 VARCHAR(30))";
    public static final String CREATE_TABLE_LOG = "CREATE TABLE IF NOT EXISTS logFile (dataLogarii VARCHAR (20), utilizator VARCHAR(50), mesaj VARCHAR (1000), rezervaLog VARCHAR(50))";
    public static final String CREATE_BLOB_TABLE = "CREATE TABLE IF NOT EXISTS fileArchive (nrCrtFile INT (6) AUTO_INCREMENT PRIMARY KEY, exist TEXT (4), nrCrtInvTBL INT (6), furnizor CHAR(100) not null, nrFactura char(40) , atasament VARCHAR (300) )";
    public static final String CREATE_ARCHIVE_PLATI_TABLE = "CREATE TABLE IF NOT EXISTS fileArchivePlati (nrCrtFileArhPl INT (6) AUTO_INCREMENT PRIMARY KEY, exist TEXT (4), nrCrtPlati INT (6), furnizor CHAR(100) not null, nrPlata char(60) , atasament VARCHAR (300) )";
    public static final String CREATE_ARCHIVE_PIF_TABLE = "CREATE TABLE IF NOT EXISTS fileArchivePIF (nrCrtFileArhPIF INT (6) AUTO_INCREMENT PRIMARY KEY, exist TEXT (4), nrPIF VARCHAR  (50), proj CHAR(5) not null, atasament VARCHAR (300) )";
    public static final String POPULATE_CONTINV_DESCRIBE = "INSERT INTO contInvDescribe  VALUES ('231.01.01.01', 'Constructii-montaj',' '),('231.02.01.01', 'Echipamente',' '),('231.02.02.01', 'Echip-in-magazie', ' '), ('231.03.01.01', 'Alte-cheltuieli', ' ') ";
    public static final String POPULATE_TABLE_RESP_PRIVILEGE = "INSERT INTO respPrivilege VALUES ('1', 'adminSorin5', '10-5B-AD-8F-65-EF', 'Level_0', 'M',' ',' '), ('2', 'adminSorin2.4', '22-5B-AD-8F-65-EF', 'Level_0', 'M',' ',' '), ('3', 'adminSorinFN', '12-5B-AD-8F-65-EF', 'Level_0', 'M',' ',' '),('4', 'adminSorinFN2', '00-15-5D-2B-36-00', 'Level_0', 'M',' ',' '),('5', 'adminSorin5.2', '12-5B-C3-8F-CE-8A', 'Level_0', 'M',' ',' ')";
    public static final String POPULATE_TABLE_RESP_PRIVILEGE1 = "INSERT INTO respPrivilege VALUES ('1', 'adminSorinMk', 'E4-54-E8-90-8F-98', 'Level_0', 'M',' ',' ') ";
    public static final String POPULATE_TABLE_DEVIZE = "INSERT INTO devizeLucrari VALUES ('1.1','Obtinerea terenului',''),('1.2','Amenajarea terenului',''),('1.3','Amenajari pentru protectia mediului',''),('2.1','Chelt pt asig utilitatilor necesare obiectivului',''),('3.1','Studii de teren',''),('3.2','Taxe pt obtinerea de avize acorduri si autorizatii',''),('3.3','Proiectare si inginerie',''),('3.4','Organizarea procedurilor de achizitie',''),('3.5','Consultanta',''),('3.6','Asistenta tehnica',''),('4.1','Constructii si instalatii',''),('4.2','Montaj utilaje tehnologice',''),('4.3','Utilaje. echip. tehnolog. si functionale cu montaj',''),('4.4','Utilaje fara montaj si echipamente de transport',''),('4.5','Dotari',''),('4.6','Active necorporale',''),('5.1.1','Constr. si instalatii afer. organizarii de santier',''),('5.1.2','Cheltuieli conexe organizarii de santier',''),('5.2','Comisioane cote legale taxe cost credit',''),('5.3','Cheltuieli diverse si neprevazute',''),('6.1','Pregatirea personalului de exploatare',''),('6.2','Probe tehnologice si teste',''),('Transf','Transferuri','')";

    @FXML
    private Label welcomeText;


    @FXML
    protected void onHelloButtonClick() throws SQLException, ClassNotFoundException {
        System.out.printf("Inceput");

        Connection connection = DriverManager.getConnection(baza.URLr, baza.USERr, baza.PASSWORDr);
        Statement statement = connection.createStatement();
        statement.executeUpdate(baza.CREATE_DATABASE);
        System.out.println("conectat principal si creare BD");

        try {
            statement.execute(baza.CREATEUSERNAME);
            statement.execute(baza.GRANT_aLL_OPTION);
            statement.execute(baza.selectUser);
            System.out.println("Creare si selectare user ");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Connection connectionFirst = DriverManager.getConnection(baza.URL, baza.USER, baza.PASSWORD);
        Statement statementINV = connectionFirst.createStatement();
        System.out.println("Conectat la noua baza de date prin noul user");
        statementINV.executeUpdate(baza.USE_DATABASE);
        statementINV.executeUpdate(baza.CREATE_TABLE);
        statementINV.executeUpdate(baza.CREATE_TABLE_BUGET_ORG);
        statementINV.executeUpdate(baza.CREATE_TABLE_BUGET_PROJ);
        statementINV.executeUpdate(baza.CREATE_TABLE_BUGET_CONTRACT);
        statementINV.executeUpdate(baza.CREATE_TABLE_RESP_PRIVILEGE);
        statementINV.executeUpdate(baza.CREATE_CONTINV_DESCRIBE);
        statementINV.executeUpdate(baza.CREATE_TABLE_PLATI);
        statementINV.executeUpdate(baza.CREATE_CONT_FZ);
        statementINV.executeUpdate(baza.CREATE_DEVIZE);
        statementINV.executeUpdate(baza.CREATE_TABLE_ANI);
        statementINV.executeUpdate(baza.CREATE_TABLE_LOG);
        statementINV.executeUpdate(baza.CREATE_BLOB_TABLE);
        statementINV.executeUpdate(baza.CREATE_ARCHIVE_PLATI_TABLE);
        statementINV.executeUpdate(baza.CREATE_ARCHIVE_PIF_TABLE);

        System.out.println("Toate bazele de date create ");

        ResultSet rsContInv = statementINV.executeQuery("Select * FROM contInvDescribe");
        String elementCont = null;
        while (rsContInv.next()) {
            elementCont = rsContInv.getNString(1);}
            if (elementCont == null) {
                statementINV.executeUpdate(baza.POPULATE_CONTINV_DESCRIBE);
                System.out.print("Conturile de investitii incarcate"+"\n");
            } else {
                System.out.print("Conturi de investitii incarcate"+"\n");
            }


        ResultSet rsPrivilegii = statementINV.executeQuery("SELECT * FROM respPrivilege");
        String elementPrivilegii=null;
        while (rsPrivilegii.next()) {
             elementPrivilegii= rsPrivilegii.getNString(1);}
            if (elementPrivilegii == null) {
                statementINV.executeUpdate(baza.POPULATE_TABLE_RESP_PRIVILEGE1);
                System.out.printf("Privilegii acordate"+"\n");
            } else {
                System.out.print("Privilegii existente"+"\n");
            }


        ResultSet rsPopDevize = statementINV.executeQuery("SELECT * FROM devizeLucrari ");
        String elementDev = null;
        while (rsPopDevize.next()) {
            elementDev = rsPopDevize.getString(1);
        }

        if (elementDev == null) {
            statementINV.executeUpdate(baza.POPULATE_TABLE_DEVIZE);
            System.out.print("Devize incarcate"+"\n");
        } else {
            System.out.print("Devize existente"+"\n");
        }



        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public static Connection getConectionNew() throws SQLException, ClassNotFoundException {
        Class.forName("org.mariadb.jdbc.Driver");
        Connection connectionInv = DriverManager.getConnection(URLr, USERr, PASSWORDr);
        Statement statement = connectionInv.createStatement();

//            Statement statementINV=connectionInv.createStatement();
//        Connection connection = DriverManager.getConnection( baza.URLr, baza.USERr, baza.PASSWORDr );
//        Statement statement= connection.createStatement();
        statement.executeUpdate(baza.CREATE_DATABASE);
        System.out.println("conectat principal si creare BD");
        return null;

    }

    @Override
    public void initialize(java.net.URL url, ResourceBundle resourceBundle) {
        try {
            getConectionNew();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}

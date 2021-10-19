package com.isg8.tp6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Usuario {

    private String nombre;
    private String apellido;
    private String telefono;
    private String razonSocial;
    private int dni;
    private String situacionIva;
    private String email;
    private String password;

    public Usuario() {

    }

    private void inicializarValores() {
        nombre = "Juan Carlos";
        apellido = "Cardozo";
        telefono = "261-5565656";
        email = "jcarlos@gmail.com";
        password = "3H03rt93GH";
    }

    public boolean login(String email, String password) {
        this.inicializarValores();
        
        if (email != "" && password != "" && email == this.email && password == this.password) {
            return true;
        } else {
            return false;
        }
    }

    public String verificarEmail(String email) {
        String result;
        String emailPattern = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@"
                + "[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$";
        Pattern pattern = Pattern.compile(emailPattern);

        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            result = "Email valido";
        } else {
            result = "Email no valido";
        }
        return result;
    }

    public boolean verificarSeguridadPassword(String password) {
        //String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
        /*
        ^                 # start-of-string
        (?=.*[0-9])       # a digit must occur at least once
        (?=.*[a-z])       # a lower case letter must occur at least once
        (?=.*[A-Z])       # an upper case letter must occur at least once
        (?=.*[@#$%^&+=])  # a special character must occur at least once
        (?=\S+$)          # no whitespace allowed in the entire string
        .{8,}             # anything, at least eight places though
        $                 # end-of-string
         */
        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}";

        return password.matches(pattern);
    }

}

package pl.accepted.challenge.services;

/**
 * Created by Marcin on 2016-03-19.
 */
public class Encryptor {

    public Encryptor() {
    }

    public  String encrypt(String pass) {

        StringBuilder result = new StringBuilder("");

        for (int i = pass.length() - 1; i >= 0; i--) {
            result.append(pass.charAt(i));
        }

        return result.toString();

    }

}

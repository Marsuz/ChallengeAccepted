package pl.accepted.challenge.model.challenges;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Marcin on 2016-03-18.
 */

@Entity
public class FirstWinChallenge implements IChallenge {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

}

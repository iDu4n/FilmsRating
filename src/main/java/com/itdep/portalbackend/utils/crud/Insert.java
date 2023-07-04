package com.itdep.portalbackend.utils.crud;

import com.itdep.portalbackend.utils.Tables;
import com.itdep.portalbackend.utils.CRUDutils;

import java.sql.SQLException;

public class Insert {

    private Insert() {}
    public static void start(int choiceTable) throws SQLException {
        if (choiceTable == 1) CRUDutils.insertActors();
        else if (choiceTable == 2) CRUDutils.insertCategory();
        else if (choiceTable == 3) CRUDutils.insertComments();
        else if (choiceTable == 4) CRUDutils.insertCountry();
        else if (choiceTable == 5) CRUDutils.insertFilm();
        else if (choiceTable == 6) CRUDutils.insertProducer();
        else if (choiceTable == 7) CRUDutils.insertRating();
        else if (choiceTable == 8) CRUDutils.insertReviews();
        else if (choiceTable == 9) CRUDutils.insertSerAndAct();
        else if (choiceTable == 10) CRUDutils.insertSerAndCat();
        else if (choiceTable == 11) CRUDutils.insertUser();

        Tables.start();
    }
}

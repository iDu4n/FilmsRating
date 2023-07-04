package com.itdep.portalbackend.utils.crud;


import com.itdep.portalbackend.utils.CRUDutils;
import com.itdep.portalbackend.utils.Tables;

import java.sql.SQLException;

public class Update {

    private Update() {}
    public static void start(int choiceTable) throws SQLException {
        if (choiceTable == 1) CRUDutils.updateActors();
        else if (choiceTable == 2) CRUDutils.updateCategory();
        else if (choiceTable == 3) CRUDutils.updateComments();
        else if (choiceTable == 4) CRUDutils.updateCountry();
        else if (choiceTable == 5) CRUDutils.updateFilm();
        else if (choiceTable == 6) CRUDutils.updateProducer();
        else if (choiceTable == 7) CRUDutils.updateRating();
        else if (choiceTable == 8) CRUDutils.updateReviews();
        else if (choiceTable == 9) CRUDutils.updateSerAndAct();
        else if (choiceTable == 10) CRUDutils.updateSerAndCat();
        else if (choiceTable == 11) CRUDutils.updateUser();

        Tables.start();
    }
}

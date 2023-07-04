package com.itdep.portalbackend.utils.crud;
import com.itdep.portalbackend.utils.CRUDutils;
import com.itdep.portalbackend.utils.Tables;

import java.sql.*;

public class Select {

    private Select() {}
    public static void start(int choiceTable) throws SQLException {
        if (choiceTable == 1) CRUDutils.selectActors();
        else if (choiceTable == 2) CRUDutils.selectCategory();
        else if (choiceTable == 3) CRUDutils.selectComments();
        else if (choiceTable == 4) CRUDutils.selectCountry();
        else if (choiceTable == 5) CRUDutils.selectFilm();
        else if (choiceTable == 6) CRUDutils.selectProducer();
        else if (choiceTable == 7) CRUDutils.selectRating();
        else if (choiceTable == 8) CRUDutils.selectReviews();
        else if (choiceTable == 9) CRUDutils.selectSerAndAct();
        else if (choiceTable == 10) CRUDutils.selectSerAndCat();
        else if (choiceTable == 11) CRUDutils.selectUser();

        Tables.start();
    }
}

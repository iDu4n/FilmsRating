package model.crud;

import model.CRUDutils;
import model.Tables;

import java.sql.SQLException;

public class Delete {

    private Delete() {    }
    public static void start(int choiceTable) throws SQLException {
        if (choiceTable == 1) CRUDutils.deleteActors();
        else if (choiceTable == 2) CRUDutils.deleteCategory();
        else if (choiceTable == 3) CRUDutils.deleteComments();
        else if (choiceTable == 4) CRUDutils.deleteCountry();
        else if (choiceTable == 5) CRUDutils.deleteFilm();
        else if (choiceTable == 6) CRUDutils.deleteProducer();
        else if (choiceTable == 7) CRUDutils.deleteRating();
        else if (choiceTable == 8) CRUDutils.deleteReviews();
        else if (choiceTable == 9) CRUDutils.deleteSerAndAct();
        else if (choiceTable == 10) CRUDutils.deleteSerAndCat();
        else if (choiceTable == 11) CRUDutils.deleteUser();

        Tables.start();
    }
}

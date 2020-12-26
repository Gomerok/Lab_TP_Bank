package com.mycompany.util;

import com.mycompany.dao.impl.AdminDAO;
import com.mycompany.dao.impl.CashierDAO;
import com.mycompany.domain.impl.Admin;
import com.mycompany.domain.impl.Cashier;

import java.sql.SQLException;
import java.util.Optional;

public class IsLoggedChecker {
    private IsLoggedChecker() {}

    public static boolean isLogged(String login, String password) {
        try {
            if (login.equals("admin")) {
                AdminDAO adminDAO = new AdminDAO();
                Optional<Admin> optionalAdmin = adminDAO.getEntityByLogin(login);

                /** change
                 *
                 */

                if (optionalAdmin.isPresent() && optionalAdmin.get().getPassword().equals(password)) {
                    return true;
                }
            } else {
                CashierDAO cashierDAO = new CashierDAO();
                Optional<Cashier> optionalCashier = cashierDAO.getEntityByLogin(login);

                /** change
                 *
                 */

                if (optionalCashier.isPresent() && optionalCashier.get().getPassword().equals(password)) {
                    return true;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }
}

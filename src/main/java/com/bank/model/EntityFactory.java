/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.model;

import java.io.Serializable;

/**
 *
 * @author ASHIM
 */
public class EntityFactory {

    public static java.io.Serializable getEntityObj(String entityName)
    {
        switch (entityName) {
            case "User":
                return (Serializable) new UserRecord();
             
            default:
                return null;
        }
    }
}

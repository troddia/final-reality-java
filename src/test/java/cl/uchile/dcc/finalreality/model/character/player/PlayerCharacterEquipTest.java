package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.magecharacter.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.magecharacter.WhiteMage;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import cl.uchile.dcc.finalreality.model.weapon.typesweapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class PlayerCharacterEquipTest {
    PlayerCharacter engineer;
    PlayerCharacter knight;
    PlayerCharacter thief;
    PlayerCharacter blackmage;
    PlayerCharacter whitemage;

    Weapon axe;
    Weapon sword;
    Weapon bow;
    Weapon knife;
    Weapon staff;

    @BeforeEach
    public void setUp() throws InvalidStatValueException {
        BlockingQueue<GameCharacter> q = new LinkedBlockingQueue<>();
        engineer = new Engineer("Engineer", 10, 10, q);
        knight = new Knight("Knight", 10, 10, q);
        thief = new Thief("Thief", 10, 10, q);
        blackmage = new BlackMage("BlackMage", 10, 10, 10, q);
        whitemage = new WhiteMage("WhiteMage", 10, 10,10, q);

        axe = new Axe("arma",10,10);
        bow = new Bow("arma", 10, 10);
        knife = new Knife("arma", 10, 10);
        staff = new Staff("arma", 10, 10);
        sword = new Sword("arma", 10, 10);
    }

    @Test
    @DisplayName("Equip Sword Restriction Test")
    void equipSwordRestrictionTest() {
        knight.equip(sword);
        assertEquals(sword,knight.getEquippedWeapon(), "Sword should be equipped");

        engineer.equip(sword);
        assertNotEquals(sword,engineer.getEquippedWeapon(), "Sword should not be equipped");

        thief.equip(sword);
        assertEquals(sword,thief.getEquippedWeapon(), "Sword should be equipped");

        blackmage.equip(sword);
        assertNotEquals(sword,blackmage.getEquippedWeapon(), "Sword should not be equipped");

        whitemage.equip(sword);
        assertNotEquals(sword,whitemage.getEquippedWeapon(), "Sword should not be equipped");
    }

    @Test
    @DisplayName("Equip Axe Restriction Test")
    void equipAxeRestrictionTest() {
        knight.equip(axe);
        assertEquals(axe,knight.getEquippedWeapon(), "Axe should be equipped");

        engineer.equip(axe);
        assertEquals(axe,engineer.getEquippedWeapon(), "Axe should be equipped");

        thief.equip(axe);
        assertNotEquals(axe,thief.getEquippedWeapon(), "Axe should not be equipped");

        blackmage.equip(axe);
        assertNotEquals(axe,blackmage.getEquippedWeapon(), "Axe should not be equipped");

        whitemage.equip(axe);
        assertNotEquals(axe,whitemage.getEquippedWeapon(), "Axe should not be equipped");
    }

    @Test
    @DisplayName("Equip Knife Restriction Test")
    void equipKnifeRestrictionTest() {
        knight.equip(knife);
        assertEquals(knife,knight.getEquippedWeapon(), "Knife should  be equipped");

        engineer.equip(knife);
        assertNotEquals(knife,engineer.getEquippedWeapon(), "Knife should not  be equipped");

        thief.equip(knife);
        assertEquals(knife,thief.getEquippedWeapon(), "Knife should  be equipped");

        blackmage.equip(knife);
        assertEquals(knife,blackmage.getEquippedWeapon(), "Knife should  be equipped");

        whitemage.equip(knife);
        assertNotEquals(knife,whitemage.getEquippedWeapon(), "Knife should not  be equipped");
    }

    @Test
    @DisplayName("Equip Bow Restriction Test")
    void equipBowRestrictionTest() {
        knight.equip(bow);
        assertNotEquals(bow,knight.getEquippedWeapon(), "Bow should not  be equipped");

        engineer.equip(bow);
        assertEquals(bow,engineer.getEquippedWeapon(), "Bow should  be equipped");

        thief.equip(bow);
        assertEquals(bow,thief.getEquippedWeapon(), "Bow should  be equipped");

        blackmage.equip(bow);
        assertNotEquals(bow,blackmage.getEquippedWeapon(), "Bow should not  be equipped");

        whitemage.equip(bow);
        assertNotEquals(bow,whitemage.getEquippedWeapon(), "Bow should not  be equipped");
    }

    @Test
    @DisplayName("Equip Staff Restriction Test")
    void equipStaffRestrictionTest() {
        knight.equip(staff);
        assertNotEquals(staff,knight.getEquippedWeapon(), "Staff should not  be equipped");

        engineer.equip(staff);
        assertNotEquals(staff,engineer.getEquippedWeapon(), "Staff should not  be equipped");

        thief.equip(staff);
        assertNotEquals(staff,thief.getEquippedWeapon(), "Staff should not  be equipped");

        blackmage.equip(staff);
        assertEquals(staff,blackmage.getEquippedWeapon(), "Staff should be equipped");

        whitemage.equip(staff);
        assertEquals(staff,whitemage.getEquippedWeapon(), "Staff should be equipped");
    }

    @Test
    @DisplayName("Case where weapon is not usable but there was a weapon equiped before")
    void NotUsableAndPrevWeaponusable() {
        //If we try to equip a weapon and the player already had one equiped, then if new weapon is not usable then
        // the previous weapon should stay equiped.
        knight.equip(sword); // We know that knight can equip a sword
        knight.equip(bow);
        assertEquals(sword, knight.getEquippedWeapon(), "Sword should be equipped, not bow");

        engineer.equip(axe); // We know that engineer can equip an axe
        engineer.equip(staff);
        assertEquals(axe, engineer.getEquippedWeapon(), "Axe should be equipped, not staff");

        thief.equip(knife); // We know that thief can equip a knife
        thief.equip(axe);
        assertEquals(knife, thief.getEquippedWeapon(), "Knife should be equipped, not axe");

        blackmage.equip(staff); // We know that a blackmage can equip a staff
        blackmage.equip(sword);
        assertEquals(staff, blackmage.getEquippedWeapon(), "Staff should be equipped, not sword");

        whitemage.equip(staff); // We know that whitemage can equip a staff
        whitemage.equip(sword);
        assertEquals(staff, whitemage.getEquippedWeapon(), "Staff should be equipped, not sword");
    }

    @Test
    @DisplayName("Case where weapon is not usable and there is no weapon equiped previously")
    void NotUsableAndNullEquipped()  {
        // The playercharacters should stay with no weapon equiped
        knight.equip(bow);
        assertNull(knight.getEquippedWeapon());

        engineer.equip(staff);
        assertNull(engineer.getEquippedWeapon());

        thief.equip(axe);
        assertNull(thief.getEquippedWeapon());

        blackmage.equip(sword);
        assertNull(blackmage.getEquippedWeapon());

        whitemage.equip(sword);
        assertNull(whitemage.getEquippedWeapon());
        //1111
    }


}
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @ParameterizedTest
    @CsvSource(value = {"0, 0", "1, 1", "2, 2", "3, 3", "4, 4", "5, 5", "6, 6", "7, 7", "8, 8", "9, 9"})
    void shouldSetCurrentStationParam(int currentStation, int expected) {

        Radio rad = new Radio();
        rad.setSumStation(rad.getSumStation());
        rad.setCurrentStation(currentStation);

        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);

        Radio rad1 = new Radio(22);

        rad1.setSumStation(rad1.getSumStation());
        rad1.setCurrentStation(currentStation);

        assertEquals(expected, rad1.getCurrentStation());

    }

    @Test
    void shouldSetCurrentStationLow() {

        Radio rad = new Radio();
        rad.setSumStation(rad.getSumStation());
        rad.setCurrentStation(-1);
        int expected = 0;

        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);

        Radio rad1 = new Radio(-1);

        rad1.setSumStation(rad1.getSumStation());
        rad1.setCurrentStation(0);

        assertEquals(0, rad1.getCurrentStation());

    }

    @Test
    void shouldSetCurrentStationHigh() {

        Radio rad = new Radio();
        rad.setSumStation(rad.getSumStation());
        rad.setCurrentStation(10);
        int expected = 0;

        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);

        Radio rad1 = new Radio(1000);

        rad1.setSumStation(rad1.getSumStation());
        rad1.setCurrentStation(999);

        assertEquals(999, rad1.getCurrentStation());

    }

    @Test
    void shouldSetCurrentStationMin() {

        Radio rad = new Radio();

        rad.setSumStation(rad.getSumStation());
        rad.setCurrentStation(0);
        int expected = 0;

        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);

        Radio rad1 = new Radio(1);

        rad1.setSumStation(rad1.getSumStation());
        rad1.setCurrentStation(0);

        assertEquals(0, rad1.getCurrentStation());

    }

    @Test
    void shouldSetCurrentStationAvr() {

        Radio rad = new Radio();

        rad.setSumStation(rad.getSumStation());
        rad.setCurrentStation(5); // rad.currentStation = 10;
        int expected = 5;

        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);

        Radio rad1 = new Radio(12);

        rad1.setSumStation(rad1.getSumStation());
        rad1.setCurrentStation(11);

        assertEquals(11, rad1.getCurrentStation());

    }

    @Test
    void shouldSetCurrentStationMax() {

        Radio rad = new Radio();
        rad.setSumStation(rad.getSumStation());
        rad.setCurrentStation(9);
        int expected = 9;

        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);

        Radio rad1 = new Radio(15);

        rad1.setSumStation(rad1.getSumStation());
        rad1.setCurrentStation(14);

        assertEquals(14, rad1.getCurrentStation());


    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv")
    void shouldNextStation(int currentStation, int expected) {

        Radio rad = new Radio();
        rad.setSumStation(rad.getSumStation());
        rad.nextStation(currentStation);
        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);

        Radio rad1 = new Radio(10);
        rad1.setSumStation(rad1.getSumStation());
        rad1.nextStation(9);
        assertEquals(0, rad1.getCurrentStation());
    }

    @Test
    void shouldNextStationUnderLimit() { // можно впихнуть параметризованный

        Radio rad = new Radio();
        rad.setSumStation(rad.getSumStation());
        rad.nextStation(-1);
        int expected = 0;

        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);

        Radio rad1 = new Radio(15);
        rad1.setSumStation(rad1.getSumStation());
        rad1.nextStation(-2);
        assertEquals(0, rad1.getCurrentStation());
    }

    @Test
    void shouldNextStationMin() { // можно впихнуть параметризованный

        Radio rad = new Radio();
        rad.setSumStation(rad.getSumStation());
        rad.nextStation(0);
        int expected = 1;

        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);

        Radio rad1 = new Radio(212);
        rad1.setSumStation(rad1.getSumStation());
        rad1.nextStation(210);
        assertEquals(211, rad1.getCurrentStation());
    }

    @Test
    void shouldNextStationAvr() { // можно впихнуть параметризованный

        Radio rad = new Radio();
        rad.setSumStation(rad.getSumStation());
        rad.nextStation(8);
        int expected = 9;

        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);

        Radio rad1 = new Radio(15);
        rad1.setSumStation(rad1.getSumStation());
        rad1.nextStation(12);
        assertEquals(13, rad1.getCurrentStation());

    }

    @Test
    void shouldNextStationMax() { // можно впихнуть параметризованный

        Radio rad = new Radio();
        rad.setSumStation(rad.getSumStation());
        rad.nextStation(9);
        int expected = 0;

        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);

        Radio rad1 = new Radio(15);
        rad1.setSumStation(rad1.getSumStation());
        rad1.nextStation(14);
        assertEquals(0, rad1.getCurrentStation());
    }

    @ParameterizedTest
    @CsvFileSource(numLinesToSkip = 10, resources = "/data1.csv")
    public void shouldPreviousStation(int currentStation, int expected) {

        Radio rad = new Radio();
        rad.setSumStation(rad.getSumStation());
        rad.previousStation(currentStation);

        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);

        Radio rad1 = new Radio(10);
        rad1.setSumStation(rad1.getSumStation());
        rad1.previousStation(currentStation);

        assertEquals(expected, rad1.getCurrentStation());
    }

    @Test
    void shouldPreviousStationUnder() { // можно парам

        Radio rad = new Radio();
        rad.setSumStation(rad.getSumStation());
        rad.previousStation(-3);

        int expected = 0;
        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);

        Radio rad1 = new Radio(20);
        rad1.setSumStation(rad1.getSumStation());
        rad1.previousStation(-2);
        assertEquals(0, rad1.getCurrentStation());
    }

    @Test
    void shouldPreviousStationMin() { // можно парам

        Radio rad = new Radio();
        rad.setSumStation(rad.getSumStation());
        rad.previousStation(0);

        int expected = 9;
        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);

        Radio rad1 = new Radio(20);
        rad1.setSumStation(rad1.getSumStation());
        rad1.previousStation(0);
        assertEquals(19, rad1.getCurrentStation());
    }

    @Test
    void shouldPreviousStationAvr() { // можно парам

        Radio rad = new Radio();
        rad.setSumStation(rad.getSumStation());
        rad.previousStation(1);

        int expected = 0;
        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);

        Radio rad1 = new Radio(20);
        rad1.setSumStation(rad1.getSumStation());
        rad1.previousStation(15);
        assertEquals(14, rad1.getCurrentStation());
    }

    @Test
    void shouldPreviousStationMax() { // можно парам

        Radio rad = new Radio();
        rad.setSumStation(rad.getSumStation());
        rad.previousStation(9);

        int expected = 8;
        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);

        Radio rad1 = new Radio(20);
        rad1.setSumStation(rad1.getSumStation());
        rad1.previousStation(19);
        assertEquals(18, rad1.getCurrentStation());
    }

    @Test
    void shouldIncreaseVolumeMax() {

        Radio rad = new Radio();
        rad.increaseVolume(100);
        int expected = 100;
        int actual = rad.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @Test
    void shouldIncreaseVolume() {

        Radio rad = new Radio();
        rad.increaseVolume(0);
        int expected = 1;
        int actual = rad.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @Test
    void shouldIncreaseVolumeUnderLimit() {

        Radio rad = new Radio();
        rad.increaseVolume(-2);
        int expected = 0;
        int actual = rad.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @Test
    void shouldDecreaseVolume() {

        Radio rad = new Radio();
        rad.decreaseVolume(100);
        int expected = 99;
        int actual = rad.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @Test
    void shouldDecreaseVolumeMin() {

        Radio rad = new Radio();
        rad.decreaseVolume(0);
        int expected = 0;
        int actual = rad.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @Test
    void shouldDecreaseVolumeOverLimit() {

        Radio rad = new Radio();
        rad.decreaseVolume(101);
        int expected = 0;
        int actual = rad.getCurrentVolume();

        assertEquals(expected, actual);
    }
}
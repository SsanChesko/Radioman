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
        rad.setCurrentStation(currentStation);

        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test
    void shouldSetCurrentStationLow() {

        Radio rad = new Radio();

        rad.setCurrentStation(-1); // rad.currentStation = 10;
        int expected = 0;

        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);

    }

    @Test
    void shouldSetCurrentStationHigh() {

        Radio rad = new Radio();

        rad.setCurrentStation(10); // rad.currentStation = 10;
        int expected = 0;

        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);

    }

    @Test
    void shouldSetCurrentStationMin() {

        Radio rad = new Radio();

        rad.setCurrentStation(0); // rad.currentStation = 10;
        int expected = 0;

        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);

    }

    @Test
    void shouldSetCurrentStationAvr() {

        Radio rad = new Radio();

        rad.setCurrentStation(5); // rad.currentStation = 10;
        int expected = 5;

        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);

    }

    @Test
    void shouldSetCurrentStationMax() {

        Radio rad = new Radio();

        rad.setCurrentStation(9); // rad.currentStation = 10;
        int expected = 9;

        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv")
    void shouldNextStation(int currentStation, int expected) {

        Radio rad = new Radio();

        rad.setCurrentStation(currentStation);
        rad.nextStation();
        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test
    void shouldNextStationUnderLimit() { // можно впихнуть параметризованный

        Radio rad = new Radio();

        rad.setCurrentStation(-5);
        rad.nextStation();
        int expected = 1;

        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test
    void shouldNextStationMin() { // можно впихнуть параметризованный

        Radio rad = new Radio();

        rad.setCurrentStation(0);
        rad.nextStation();
        int expected = 1;

        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test
    void shouldNextStationAvr() { // можно впихнуть параметризованный

        Radio rad = new Radio();

        rad.setCurrentStation(8);
        rad.nextStation();
        int expected = 9;

        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test
    void shouldNextStationMax() { // можно впихнуть параметризованный

        Radio rad = new Radio();

        rad.setCurrentStation(9);
        rad.nextStation();
        int expected = 0;

        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(numLinesToSkip = 10, resources = "/data1.csv")
    public void shouldPreviousStation(int currentStation, int expected) {

        Radio rad = new Radio();
        rad.setCurrentStation(currentStation);
        rad.previousStation();

        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test
    void shouldPreviousStationUnder() { // можно парам

        Radio rad = new Radio();
        rad.setCurrentStation(-3);
        rad.previousStation();

        int expected = 9;
        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test
    void shouldPreviousStationMin() { // можно парам

        Radio rad = new Radio();
        rad.setCurrentStation(0);
        rad.previousStation();

        int expected = 9;
        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test
    void shouldPreviousStationAvr() { // можно парам

        Radio rad = new Radio();
        rad.setCurrentStation(1);
        rad.previousStation();

        int expected = 0;
        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test
    void shouldPreviousStationMax() { // можно парам

        Radio rad = new Radio();
        rad.setCurrentStation(9);
        rad.previousStation();

        int expected = 8;
        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test
    void shouldIncreaseVolumeMax() {

        Radio rad = new Radio();
        rad.setCurrentVolume(10);
        rad.increaseVolume();
        int expected = 10;
        int actual = rad.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @Test
    void shouldIncreaseVolume() {

        Radio rad = new Radio();
        rad.setCurrentVolume(5);
        rad.increaseVolume();
        int expected = 6;
        int actual = rad.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @Test
    void shouldDecreaseVolume() {

        Radio rad = new Radio();
        rad.setCurrentVolume(10);
        rad.decreaseVolume();
        int expected = 9;
        int actual = rad.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @Test
    void shouldDecreaseVolumeMin() {

        Radio rad = new Radio();
        rad.setCurrentVolume(0);
        rad.decreaseVolume();
        int expected = 0;
        int actual = rad.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @Test
    void shouldDecreaseVolumeOverLimit() {

        Radio rad = new Radio();
        rad.setCurrentVolume(12);
        rad.decreaseVolume();
        int expected = 0;
        int actual = rad.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @Test
    void shouldDecreaseVolumeAvr() {

        Radio rad = new Radio();
        rad.setCurrentVolume(8);
        rad.decreaseVolume();
        int expected = 7;
        int actual = rad.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @Test
    void shouldDecreaseVolumeOverMin() {

        Radio rad = new Radio();
        rad.setCurrentVolume(-5);
        rad.decreaseVolume();
        int expected = 0;
        int actual = rad.getCurrentVolume();

        assertEquals(expected, actual);
    }
}


public class Radio {
    private int currentStation;
    private int currentVolume;
    private int sumStation = 10;

    public Radio(int sumStation) {
        this.sumStation = sumStation;
    }

    public Radio() {
    }

    public int getSumStation() {
        return sumStation - 1;
    }

    public void setSumStation(int sumStation) {
        this.sumStation = sumStation;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int currentStation) {
        if (currentStation < 0) {
            return;
        }
        if (currentStation > sumStation) {
            return;
        }
        this.currentStation = currentStation;
    }

    public void nextStation() {
        if (currentStation < sumStation) {
            this.currentStation = currentStation + 1;
            return;
        }
        if (currentStation == sumStation) {
            this.currentStation = 0;
        }
    }

    public void previousStation() {
        if (currentStation == 0) {
            this.currentStation = sumStation;
            return;
        }
        if (currentStation < sumStation) {
            this.currentStation = currentStation - 1;
            return;
        }
        if (currentStation == sumStation) {
            this.currentStation = currentStation - 1;
        }

    }


    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int currentVolume) {
        if (currentVolume < 0) {
            return;
        }
        if (currentVolume > 100) {
            return;
        }
        this.currentVolume = currentVolume;
    }

    public void increaseVolume() {
        if (currentVolume < 100) {
            this.currentVolume = currentVolume + 1;
            return;
        }
        if (currentVolume == 100) {
            this.currentVolume = 100;
        }
    }

    public void decreaseVolume() {
        if (currentVolume == 0) {
            this.currentVolume = 0;
            return;
        }
        if (currentVolume <= 100) {
            this.currentVolume = currentVolume - 1;
        }
    }
}



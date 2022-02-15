import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Radio {
    private int currentStation;
    private int currentVolume;
    private int sumStation = 10;

   /* public Radio(int sumStation) {
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

    public void nextStation(int currentStation) {
        if (currentStation < 0) {
            return;
        }
        if (currentStation < sumStation) {
            this.currentStation = currentStation + 1;
        }
        if (currentStation == sumStation) {
            this.currentStation = 0;
        }
    }

    public void previousStation(int currentStation) {
        if (currentStation < 0)
            return;
        if (currentStation < sumStation) {
            this.currentStation = currentStation - 1;
        }
        if (currentStation == 0) {
            this.currentStation = sumStation;
        }
        if (currentStation == sumStation) {
            this.currentStation = currentStation - 1;
        }

    }


    public int getCurrentVolume() {
        return currentVolume;
    }

    public void increaseVolume(int currentVolume) {
        if (currentVolume < 0) {
            return;
        }
        if (currentVolume < 100) {
            this.currentVolume = currentVolume + 1;
        }
        if (currentVolume == 100) {
            this.currentVolume = 100;
        }
    }

    public void decreaseVolume(int currentVolume) {
        if (currentVolume > 100)
            return;
        if (currentVolume >= 100) {
            this.currentVolume = currentVolume - 1;
        }
        if (currentVolume == 0) {
            this.currentVolume = 0;
        }
    }

    */
}



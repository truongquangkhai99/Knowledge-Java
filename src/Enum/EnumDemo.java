package Enum;

enum Transport {
    CAR(65), TRUCK(55), AIRPLANE(600), TRAIN(70), BOAT(22);

    private int speed;

    Transport(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}

public class EnumDemo {
    public static void main(String[] args) {
        Transport transport = Transport.CAR;
        System.out.println("CAR SPEED : " + transport.getSpeed());
        transport = Transport.AIRPLANE;
        if (transport == Transport.AIRPLANE) {
            System.out.println("AIRPLANE SPEED : " + transport.getSpeed());
        }
        switch(transport) {
            case CAR:
                System.out.println("Tôi đang đi xe hơi");
                break;
            case TRUCK:
                System.out.println("Tôi đang đi xe tải");
                break;
            case AIRPLANE:
                System.out.println("Tôi đang đi máy bay");
                break;
            case TRAIN:
                System.out.println("Tôi đang đi xe lửa");
                break;
            case BOAT:
                System.out.println("Tôi đang đi thuyền");
                break;
            default:
                System.out.println("Tôi đi bộ ^^!");
                break;
        }
        transport = Transport.valueOf("BOAT");
        System.out.println("Chuyển qua đi " + transport.name());
        System.out.println("D/sách các phương tiện nhà tôi:");
        for(Transport transportItem : Transport.values()) {
            System.out.println("- Phương tiện : " + transportItem.name() + " - Tốc độ : " + transportItem.getSpeed() + " - Vị trí đậu : " + transportItem.ordinal());
        }
        System.out.println("ENUM không thể dùng với từ khóa extends - nó không thể là 1 lớp cha hay con, nhưng vẫn có thể implements nha");
        if (Transport.AIRPLANE.compareTo(Transport.CAR) > 0) {
            System.out.println("Máy bay đậu sau xe hơi");
        } else {
            System.out.println("Máy bay đậu trước xe hơi");
        }
    }
}

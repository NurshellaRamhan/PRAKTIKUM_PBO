import java.util.ArrayList;
import java.util.Scanner;

// Superclass Person
class Person {
    private String nama;
    private String noTelp;

    public Person(String nama, String noTelp) {
        this.nama = nama;
        this.noTelp = noTelp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    @Override
    public String toString() {
        return "Nama: " + nama + ", No Telp: " + noTelp;
    }
}

// Subclass Customer
class Customer extends Person {
    public Customer(String nama, String noTelp) {
        super(nama, noTelp);
    }

    // Overriding toString
    @Override
    public String toString() {
        return "[Customer] " + super.toString();
    }
}

// Subclass Staff (Poin Plus)
class Staff extends Person {
    private String posisi;

    public Staff(String nama, String noTelp, String posisi) {
        super(nama, noTelp);
        this.posisi = posisi;
    }

    public String getPosisi() {
        return posisi;
    }

    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }

    @Override
    public String toString() {
        return "[Staff] " + super.toString() + ", Posisi: " + posisi;
    }
}

// Class Booking
class Booking {
    private String idBooking;
    private Customer customer;
    private String tanggal;
    private String jam;

    public Booking(String idBooking, Customer customer, String tanggal, String jam) {
        this.idBooking = idBooking;
        this.customer = customer;
        this.tanggal = tanggal;
        this.jam = jam;
    }

    @Override
    public String toString() {
        return "ID Booking: " + idBooking + ", " + customer + ", Tanggal: " + tanggal + ", Jam: " + jam;
    }
}

// Class Antrian
class Antrian {
    private String idAntrian;
    private Customer customer;
    private int nomorAntrian;

    public Antrian(String idAntrian, Customer customer, int nomorAntrian) {
        this.idAntrian = idAntrian;
        this.customer = customer;
        this.nomorAntrian = nomorAntrian;
    }

    @Override
    public String toString() {
        return "ID Antrian: " + idAntrian + ", " + customer + ", Nomor Antrian: " + nomorAntrian;
    }
}

// Main Class
public class SistemBookingRestoran_Inheritance {
    private static ArrayList<Booking> listBooking = new ArrayList<>();
    private static ArrayList<Antrian> listAntrian = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int pilih;
        do {
            System.out.println("\n=== MENU SISTEM BOOKING & ANTRIAN BONCAFE ===");
            System.out.println("1. Tambah Booking");
            System.out.println("2. Lihat Booking");
            System.out.println("3. Tambah Antrian");
            System.out.println("4. Lihat Antrian");
            System.out.println("5. Keluar");
            System.out.println("6. Demo Overloading");
            System.out.print("Pilih menu: ");
            pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {
                case 1 -> tambahBooking();
                case 2 -> tampilBooking();
                case 3 -> tambahAntrian();
                case 4 -> tampilAntrian();
                case 5 -> System.out.println("Terima kasih!");
                case 6 -> demoOverload();
                default -> System.out.println("Menu tidak tersedia.");
            }
        } while (pilih != 5);
    }

    // Original method
    public static void tambahBooking() {
        System.out.print("ID Booking: ");
        String id = input.nextLine();
        System.out.print("Nama Customer: ");
        String nama = input.nextLine();
        System.out.print("No Telepon: ");
        String telp = input.nextLine();
        System.out.print("Tanggal (YYYY-MM-DD): ");
        String tgl = input.nextLine();
        System.out.print("Jam (HH:MM): ");
        String jam = input.nextLine();

        Customer cust = new Customer(nama, telp);
        Booking book = new Booking(id, cust, tgl, jam);
        listBooking.add(book);
        System.out.println("Booking berhasil ditambahkan.");
    }

    // Overloaded method
    public static void tambahBooking(String id, Customer cust, String tanggal, String jam) {
        Booking book = new Booking(id, cust, tanggal, jam);
        listBooking.add(book);
        System.out.println("Booking berhasil ditambahkan (overload).");
    }

    public static void tampilBooking() {
        if (listBooking.isEmpty()) {
            System.out.println("Data booking kosong.");
        } else {
            for (Booking b : listBooking) {
                System.out.println(b);
            }
        }
    }

    public static void tambahAntrian() {
        System.out.print("ID Antrian: ");
        String id = input.nextLine();
        System.out.print("Nama Customer: ");
        String nama = input.nextLine();
        System.out.print("No Telepon: ");
        String telp = input.nextLine();
        int nomor = listAntrian.size() + 1;

        Customer cust = new Customer(nama, telp);
        Antrian antre = new Antrian(id, cust, nomor);
        listAntrian.add(antre);
        System.out.println("Antrian berhasil ditambahkan.");
    }

    // Overloaded method
    public static void tambahAntrian(String id, Customer cust) {
        int nomor = listAntrian.size() + 1;
        Antrian antre = new Antrian(id, cust, nomor);
        listAntrian.add(antre);
        System.out.println("Antrian berhasil ditambahkan (overload).");
    }

    public static void tampilAntrian() {
        if (listAntrian.isEmpty()) {
            System.out.println("Data antrian kosong.");
        } else {
            for (Antrian a : listAntrian) {
                System.out.println(a);
            }
        }
    }

    // Demo Polymorphism - Overloading
    public static void demoOverload() {
        System.out.println("\n=== DEMO METHOD OVERLOADING ===");
        Customer c1 = new Customer("Budi", "081111111111");
        tambahBooking("B004", c1, "2025-04-10", "19:00");

        Customer c2 = new Customer("Sari", "082222222222");
        tambahAntrian("A004", c2);
    }
}

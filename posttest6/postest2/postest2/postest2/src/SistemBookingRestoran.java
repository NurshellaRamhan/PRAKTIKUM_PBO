import java.util.ArrayList;
import java.util.Scanner;

// Class Customer
class Customer {
    private String nama;
    private String noTelp;

    public Customer(String nama, String noTelp) {
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

    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
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

    public String getIdAntrian() {
        return idAntrian;
    }

    public void setIdAntrian(String idAntrian) {
        this.idAntrian = idAntrian;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getNomorAntrian() {
        return nomorAntrian;
    }

    public void setNomorAntrian(int nomorAntrian) {
        this.nomorAntrian = nomorAntrian;
    }

    @Override
    public String toString() {
        return "ID Antrian: " + idAntrian + ", " + customer + ", Nomor Antrian: " + nomorAntrian;
    }
}

// Main Class
public class SistemBookingRestoran {
    private static ArrayList<Booking> listBooking = new ArrayList<>();
    private static ArrayList<Antrian> listAntrian = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int pilih;
        do {
            System.out.println("\n=== MENU SISTEM BOOKING & ANTRIAN BONCAFE ===");
            System.out.println("1. Tambah Booking");
            System.out.println("2. Lihat Booking");
            System.out.println("3. Update Booking");
            System.out.println("4. Hapus Booking");
            System.out.println("5. Tambah Antrian");
            System.out.println("6. Lihat Antrian");
            System.out.println("7. Keluar");
            System.out.print("Pilih menu: ");
            pilih = input.nextInt();
            input.nextLine(); // Buang newline

            switch (pilih) {
                case 1 -> tambahBooking();
                case 2 -> tampilBooking();
                case 3 -> updateBooking();
                case 4 -> hapusBooking();
                case 5 -> tambahAntrian();
                case 6 -> tampilAntrian();
                case 7 -> System.out.println("Terima kasih!");
                default -> System.out.println("Menu tidak tersedia.");
            }
        } while (pilih != 7);
    }

    // === Booking Section ===
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

    public static void tampilBooking() {
        if (listBooking.isEmpty()) {
            System.out.println("Data booking kosong.");
        } else {
            for (Booking b : listBooking) {
                System.out.println(b);
            }
        }
    }

    public static void updateBooking() {
        System.out.print("Masukkan ID Booking yang akan diupdate: ");
        String id = input.nextLine();
        for (Booking b : listBooking) {
            if (b.getIdBooking().equals(id)) {
                System.out.print("Nama baru: ");
                b.getCustomer().setNama(input.nextLine());
                System.out.print("No Telp baru: ");
                b.getCustomer().setNoTelp(input.nextLine());
                System.out.print("Tanggal baru: ");
                b.setTanggal(input.nextLine());
                System.out.print("Jam baru: ");
                b.setJam(input.nextLine());
                System.out.println("Booking berhasil diupdate.");
                return;
            }
        }
        System.out.println("Booking dengan ID tersebut tidak ditemukan.");
    }

    public static void hapusBooking() {
        System.out.print("Masukkan ID Booking yang akan dihapus: ");
        String id = input.nextLine();
        for (int i = 0; i < listBooking.size(); i++) {
            if (listBooking.get(i).getIdBooking().equals(id)) {
                listBooking.remove(i);
                System.out.println("Booking berhasil dihapus.");
                return;
            }
        }
        System.out.println("Booking tidak ditemukan.");
    }

    // === Antrian Section ===
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

    public static void tampilAntrian() {
        if (listAntrian.isEmpty()) {
            System.out.println("Data antrian kosong.");
        } else {
            for (Antrian a : listAntrian) {
                System.out.println(a);
            }
        }
    }
}
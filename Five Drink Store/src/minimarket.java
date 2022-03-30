import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class BinarySearchTree {
    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root;

    // Inisial empty tree
    BinarySearchTree() {
        root = null;
    }

    // menghapus node dari BST
    void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    Node deleteRec(Node root, int key) {
        // tree isEmpty
        if (root == null)
            return root;
        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.key = minValue(root.right);

            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {

        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    public boolean search(int key) {
        return search(this.root, key);
    }

    private boolean search(Node root, int key) {
        if (root == null) {
            return false;
        } else if (root.key == key) {
            return true;
        } else if (root.key > key) {
            return search(root.left, key);
        }
        return search(root.right, key);
    }
}

public class minimarket {
    public static void main(String[] args) {
        int PilihanMO, PilihanCus;
        int i = 0, kode, barcode;
        int finish = -1;
        String menu, PilihanW2, PilihanW3;
        String NamaIn;
        int jumlah, minuman;
        boolean pilihan, pilihan1, pilihan2, pilihan4, pilihan5;
        // Tumpukan minuman di kulkas
        Stack<Integer> nescafe = new Stack<Integer>();
        Stack<Integer> milo = new Stack<Integer>();
        Stack<Integer> cola = new Stack<Integer>();
        Stack<Integer> sprite = new Stack<Integer>();
        Stack<Integer> fanta = new Stack<Integer>();
        // Antrian barang di gudang
        Queue<Integer> gudang_nescafe = new LinkedList<>();
        Queue<Integer> gudang_milo = new LinkedList<>();
        Queue<Integer> gudang_cola = new LinkedList<>();
        Queue<Integer> gudang_sprite = new LinkedList<>();
        Queue<Integer> gudang_fanta = new LinkedList<>();
        // Menyimpan riwayat kode dus yang masuk ke gudang
        ArrayList<Integer> kodedus_nescafe = new ArrayList<>();
        ArrayList<Integer> kodedus_milo = new ArrayList<>();
        ArrayList<Integer> kodedus_cola = new ArrayList<>();
        ArrayList<Integer> kodedus_sprite = new ArrayList<>();
        ArrayList<Integer> kodedus_fanta = new ArrayList<>();
        // Menyimpan riwayat belanjacustomer
        ArrayList<String> pesanan = new ArrayList<>();
        // Bst
        BinarySearchTree tree = new BinarySearchTree();

        try (Scanner Input = new Scanner(System.in)) {
            do {
                System.out.println("\n*******************************************");
                System.out.println("              FIVE DRINK STORE             ");
                System.out.println("*******************************************");
                System.out.println("Owner    (o) Stok barang di gudang");
                System.out.println("Customer (c) Belanja di minimarket");
                System.out.println("Pilihan (o/c) ? ");
                menu = Input.nextLine();
                System.out.println("*******************************************");
                switch (menu) {
                    // Menu Owner
                    case "o":
                        do {
                            System.out.println("\n================================================");
                            System.out.println("  Menu Owner [pengecekan stok brang di gudang]");
                            System.out.println("================================================");
                            System.out.println("1. Cek daftar stok dus barang di gudang"); // isempty LinkedList
                            System.out.println("2. Tambah stok barang(/dus) di gudang"); // Enqueue LinkedList dan
                                                                                         // treeinsert
                            System.out.println("3. Daftar stok dus barang di gudang"); // Queue LinkedList
                            System.out.println("4. Cek produk di store"); // isempty Stack
                            System.out.println("5. Ambil stok barang(/dus) dari gudang = kulkas di store di isi"); // Dequeue
                                                                                                                   // LinkedList,
                            // treedeleteKey, dan Push Stack
                            System.out.println("6. Pencarian kode dus barang di gudang"); // cari nilai class binaryTree
                            System.out.println("=-------------------------=");
                            System.out.println("Pilih Menu OWNER nomor? :  ");
                            PilihanMO = Input.nextInt();
                            System.out.println("=-------------------------=");
                            switch (PilihanMO) {
                                case 1: // isEmpty Queue
                                    System.out.println("\n''''''''''''''''''''''''''''''''''''''''''''");
                                    System.out.println("Stok dus barang di gudang ");
                                    if (gudang_nescafe.isEmpty() == true) {
                                        System.out.println("> Tidak ada stok dus Nescafe di gudang");

                                    } else {
                                        System.out.println("> Stok dus Nescafe sudah ada di gudang");
                                    }
                                    if (gudang_milo.isEmpty() == true) {
                                        System.out.println("> Tidak ada stok dus Milo di gudang");
                                    } else {
                                        System.out.println("> Stok dus Milo sudah ada di gudang");
                                    }
                                    if (gudang_cola.isEmpty() == true) {
                                        System.out.println("> Tidak ada stok dus Cocacola di gudang");
                                    } else {
                                        System.out.println("> Stok dus Cocacola sudah ada di gudang");
                                    }
                                    if (gudang_fanta.isEmpty() == true) {
                                        System.out.println("> Tidak ada stok dus Fanta di gudang");
                                    } else {
                                        System.out.println("> Stok dus Fanta sudah ada di gudang");
                                    }
                                    if (gudang_sprite.isEmpty() == true) {
                                        System.out.println("> Tidak ada stok dus Sprite di gudang");
                                    } else {
                                        System.out.println("> Stok dus Sprite sudah ada di gudang");
                                    }
                                    System.out.println("''''''''''''''''''''''''''''''''''''''''''''");
                                    break;

                                case 2: // add Queue
                                    System.out.println("\n''''''''''''''''''''''''''''''''''''''''''''");
                                    do {
                                        System.out.println("\n================");
                                        System.out.println("|    Drink     |");
                                        System.out.println("================");
                                        System.out.println("| Nescafe  (n) |");
                                        System.out.println("| Milo     (m) |");
                                        System.out.println("| Cocacola (c) |");
                                        System.out.println("| Fanta    (f) |");
                                        System.out.println("| Sprite   (s) |");
                                        System.out.println("================");
                                        System.out.println("Pilih minuman yang akan masuk ke gudang : ");
                                        PilihanW2 = Input.next();
                                        switch (PilihanW2) {
                                            case "n":
                                                System.out.print("Banyak Stok dus Nescafe yang masuk : ");
                                                i = 0;
                                                int j = Input.nextInt();
                                                System.out.println("> Kode dus Nescafe dimulai dari '1..'");
                                                do {
                                                    System.out.print("Masukan kode dus : ");
                                                    kode = Input.nextInt();
                                                    tree.insert(kode);
                                                    gudang_nescafe.add(kode);
                                                    kodedus_nescafe.add(kode);
                                                    i++;
                                                } while (i < j);
                                                System.out.println("Kode dus Nescafe : " + gudang_nescafe);
                                                break;
                                            case "m":
                                                System.out.print("Banyak Stok dus Milo yang masuk : ");
                                                i = 0;
                                                int k = Input.nextInt();
                                                System.out.println("> Kode dus Milo dimulai dari '2..'");
                                                do {
                                                    System.out.print("Masukan kode dus : ");
                                                    kode = Input.nextInt();
                                                    tree.insert(kode);
                                                    gudang_milo.add(kode);
                                                    kodedus_milo.add(kode);
                                                    i++;
                                                } while (i < k);
                                                System.out.println("Kode dus Milo : " + gudang_milo);
                                                break;
                                            case "c":
                                                System.out.print("Banyak Stok Cocacola/dus yang masuk : ");
                                                i = 0;
                                                int l = Input.nextInt();
                                                System.out.println("> Kode dus Cocacola dimulai dari '3..'");
                                                do {
                                                    System.out.print("Masukan kode dus : ");
                                                    kode = Input.nextInt();
                                                    tree.insert(kode);
                                                    gudang_cola.add(kode);
                                                    kodedus_cola.add(kode);
                                                    i++;
                                                } while (i < l);
                                                System.out.println("Kode dus Cocacola : " + gudang_cola);
                                                break;
                                            case "f":
                                                System.out.print("Banyak Stok Fanta/dus yang masuk : ");
                                                i = 0;
                                                int m = Input.nextInt();
                                                System.out.println("> Kode dus Fanta dimulai dari '4..'");
                                                do {
                                                    System.out.print("Masukan kode dus : ");
                                                    kode = Input.nextInt();
                                                    tree.insert(kode);
                                                    gudang_fanta.add(kode);
                                                    kodedus_fanta.add(kode);
                                                    i++;
                                                } while (i < m);
                                                System.out.println("Kode dus Fanta : " + gudang_fanta);
                                                break;
                                            case "s":
                                                System.out.print("Banyak Stok Sprite/dus yang masuk : ");
                                                i = 0;
                                                int n = Input.nextInt();
                                                System.out.println("> Kode dus Sprite dimulai dari '5..'");
                                                do {
                                                    System.out.print("Masukan kode dua  : ");
                                                    kode = Input.nextInt();
                                                    tree.insert(kode);
                                                    gudang_sprite.add(kode);
                                                    kodedus_sprite.add(kode);
                                                    i++;
                                                } while (i < n);
                                                System.out.println("Kode dus Sprite : " + gudang_sprite);
                                                break;
                                        }
                                        System.out.println("\nDaftar Kode Minuman (BT): ");
                                        tree.inorder();
                                        System.out.println("\nIsi Stock Minuman Lain ? (true/false) : ");
                                        pilihan2 = Input.nextBoolean();
                                    } while (pilihan2);
                                    System.out.println("''''''''''''''''''''''''''''''''''''''''''''");
                                    break;

                                case 3: // menampilkan value dalam Queue
                                    System.out.println("\n''''''''''''''''''''''''''''''''''''''''''''");
                                    System.out.println("> Daftar stok dus barang di gudang");
                                    System.out.println("Kode dus Nescafe  : " + gudang_nescafe);
                                    System.out.println("Kode dus Milo     : " + gudang_milo);
                                    System.out.println("Kode dus Cocacola : " + gudang_cola);
                                    System.out.println("Kode dus Fanta    : " + gudang_fanta);
                                    System.out.println("Kode dus Sprite   : " + gudang_sprite);
                                    System.out.println("''''''''''''''''''''''''''''''''''''''''''''");
                                    break;

                                case 4: // isEmpty Stack
                                    System.out.println("\n''''''''''''''''''''''''''''''''''''''''''''");
                                    System.out.println("Stok Minuman di store ");
                                    if (nescafe.isEmpty()) {
                                        System.out.println("Tidak ada stok Nescafe di store");
                                    } else {
                                        System.out.println("Nescafe sudah tersedia di store");
                                    }
                                    if (milo.isEmpty()) {
                                        System.out.println("Tidak ada stok Milo di store");
                                    } else {
                                        System.out.println("Milo sudah tersedia di store");
                                    }
                                    if (cola.isEmpty()) {
                                        System.out.println("Tidak ada stok Cocacola di store");
                                    } else {
                                        System.out.println("Cocacola sudah tersedia di store");
                                    }
                                    if (fanta.isEmpty()) {
                                        System.out.println("Tidak ada stok Fanta di store");
                                    } else {
                                        System.out.println("Fanta sudah tersedia di store");
                                    }
                                    if (sprite.isEmpty()) {
                                        System.out.println("Tidak ada stok Sprite di store");
                                    } else {
                                        System.out.println("Sprite sudah tersedia di store");
                                    }
                                    System.out.println("''''''''''''''''''''''''''''''''''''''''''''");
                                    break;

                                case 5: // poll Queue, push stack, treedelete key,
                                    System.out.println("\n''''''''''''''''''''''''''''''''''''''''''''");
                                    do {
                                        System.out.println("\n================");
                                        System.out.println("|     Drink    |");
                                        System.out.println("================");
                                        System.out.println("| Nescafe  (n) |");
                                        System.out.println("| Milo     (m) |");
                                        System.out.println("| Cocacola (c) |");
                                        System.out.println("| Fanta    (f) |");
                                        System.out.println("| Sprite   (s) |");
                                        System.out.println("================");
                                        System.out.println("Pilih minuman yang akan diambil dari gudang");
                                        PilihanW3 = Input.next();
                                        switch (PilihanW3) {
                                            case "n":
                                                if (nescafe.size() <= 24 && gudang_nescafe.isEmpty() != true) {
                                                    System.out.println("> Daftar kode dus Nescafe di gudang");
                                                    System.out.println(gudang_nescafe);
                                                    System.out.println(
                                                            "Kode dus Nescafe yang akan diambil : "
                                                                    + gudang_nescafe.peek());

                                                    for (int a = 1; a <= 24; a++) {
                                                        nescafe.push(10100 + a);
                                                    }
                                                    if (nescafe.size() <= 24) {
                                                        System.out.println("> Nescafe sudah restock di Store");
                                                        System.out.println("Code minuman Nescafe : " + nescafe);
                                                        tree.deleteKey(gudang_nescafe.poll());
                                                    } else {
                                                        System.out.println("Maaf minuman di store penuh");
                                                    }
                                                } else {
                                                    System.out.println("Maaf Tidak ada stok Nescafe di gudang");
                                                }
                                                break;
                                            case "m":
                                                if (milo.size() <= 24 && gudang_milo.isEmpty() != true) {
                                                    System.out.println("> Daftar kode dus Milo di gudang");
                                                    System.out.println(gudang_milo);
                                                    System.out
                                                            .println("Kode dus Milo yang akan diambil : "
                                                                    + gudang_milo.peek());
                                                    for (int b = 1; b <= 24; b++) {
                                                        milo.push(20200 + b);
                                                    }
                                                    if (milo.size() <= 24) {
                                                        System.out.println("> Milo sudah restock di Store");
                                                        System.out.println("Code Milo : " + milo);
                                                        tree.deleteKey(gudang_milo.poll());
                                                    } else {
                                                        System.out.println("Maaf minuman di store penuh");
                                                    }
                                                } else {
                                                    System.out.println("Maaf Tidak ada stok Milo di gudang");
                                                }
                                                break;
                                            case "c":
                                                if (cola.size() <= 24 && gudang_cola.isEmpty() != true) {
                                                    System.out.println("> Daftar kode dus Cocacola di gudang");
                                                    System.out.println(gudang_cola);
                                                    System.out.println(
                                                            "Kode dus Cocacola yang akan diambil : "
                                                                    + gudang_cola.peek());
                                                    for (int c = 1; c <= 24; c++) {
                                                        cola.push(30300 + c);
                                                    }
                                                    if (cola.size() <= 24) {
                                                        System.out.println("> Cocacola sudah restock di Store");
                                                        System.out.println("Code Cocacola : " + cola);
                                                        tree.deleteKey(gudang_cola.poll());
                                                    } else {
                                                        System.out.println("Maaf minuman di store penuh");
                                                    }
                                                } else {
                                                    System.out.println("Maaf Tidak ada stok Cocacola di gudang");
                                                }
                                                break;
                                            case "f":
                                                if (fanta.size() <= 24 && gudang_fanta.isEmpty() != true) {
                                                    System.out.println("> Daftar kode dus Fanta di gudang");
                                                    System.out.println(gudang_fanta);
                                                    System.out.println(
                                                            "Kode dus Fanta yang akan diambil : "
                                                                    + gudang_fanta.peek());
                                                    for (int c = 1; c <= 24; c++) {
                                                        fanta.push(30300 + c);
                                                    }
                                                    if (fanta.size() <= 24) {
                                                        System.out.println("> Fanta sudah restock di Store");
                                                        System.out.println("Code Fanta : " + fanta);
                                                        tree.deleteKey(gudang_fanta.poll());
                                                    } else {
                                                        System.out.println("Maaf minuman di store penuh");
                                                    }
                                                } else {
                                                    System.out.println("Maaf Tidak ada stok Fanta di gudang");
                                                }
                                                break;
                                            case "s":
                                                if (sprite.size() <= 24 && gudang_sprite.isEmpty() != true) {
                                                    System.out.println("> Daftar kode dus Sprite di gudang");
                                                    System.out.println(gudang_sprite);
                                                    System.out.println(
                                                            "Kode dus Sprite yang akan diambil : "
                                                                    + gudang_sprite.peek());
                                                    for (int c = 1; c <= 24; c++) {
                                                        sprite.push(30300 + c);
                                                    }
                                                    if (sprite.size() <= 24) {
                                                        System.out.println("> Sprite sudah restock di Store");
                                                        System.out.println("Code Sprite : " + sprite);
                                                        tree.deleteKey(gudang_sprite.poll());
                                                    } else {
                                                        System.out.println("Maaf minuman di store penuh");
                                                    }
                                                } else {
                                                    System.out.println("Maaf Tidak ada stok Sprite di gudang");
                                                }
                                                break;
                                        }
                                        System.out.println("\nAmbil Stok Minuman Lagi ? (true/false) : ");
                                        pilihan5 = Input.nextBoolean();
                                    } while (pilihan5);
                                    System.out.print("> Kode dus minuman yang tersisa di gudang : "); // menampilkan
                                                                                                      // value
                                                                                                      // dalam tree
                                    tree.inorder();
                                    System.out.println("\n''''''''''''''''''''''''''''''''''''''''''''");
                                    break;

                                case 6:
                                    // Mencari nilai di class binaryTree
                                    System.out.println("\n''''''''''''''''''''''''''''''''''''''''''''");
                                    System.out.println("RIWAYAT Kode dus yang masuk ke gudang  ");
                                    System.out.println("> Kode dus Nescafe");
                                    System.out.println(kodedus_nescafe);
                                    System.out.println("> Kode dus Milo");
                                    System.out.println(kodedus_milo);
                                    System.out.println("> Kode dus Cocacola");
                                    System.out.println(kodedus_cola);
                                    System.out.println("> Kode dus Fanta");
                                    System.out.println(kodedus_fanta);
                                    System.out.println("> Kode dus Sprite");
                                    System.out.println(kodedus_sprite);
                                    System.out.println("\nPencarian kode dus yang masih tersedia di gudang");
                                    System.out.println("> Kode dus yang akan dicari ");
                                    barcode = Input.nextInt();
                                    boolean s_val = tree.search(barcode);
                                    if (s_val == true) {
                                        s_val = tree.search(barcode);
                                        System.out.println(
                                                "Dus minuman dengan kode " + barcode + " masih tersedia di gudang");
                                    } else {
                                        s_val = tree.search(barcode);
                                        System.out.println(
                                                "Dus minuman dengan kode " + barcode
                                                        + " sudah tidak tersedia di gudang");
                                    }

                                    System.out.println("''''''''''''''''''''''''''''''''''''''''''''");
                                    break;

                                default:
                                    System.out.println("\nPilihan tidak ditemukan");
                                    break;
                            }

                            System.out.println("\n>> Pilihan Menu Owner Lainnya ? (true/false) : ");
                            pilihan = Input.nextBoolean();
                        } while (pilihan);
                        break;

                    // Menu Customer
                    case "c":
                        do {
                            System.out.println("\n================================================");
                            System.out.println("         Menu Customer Five Drink Store        ");
                            System.out.println("================================================");
                            System.out.println("1. Pesan Minuman"); // Pemesanan
                            System.out.println("2. Cek Daftar Minuman di Kulkas (Store)"); // Menamilkan Stack
                            System.out.println("=------------------=");
                            System.out.println("Masukann pilihan : ");
                            PilihanCus = Input.nextInt();
                            System.out.println("=------------------=");
                            switch (PilihanCus) {
                                case 1:
                                    do {
                                        System.out.println("\n*---Selamat Datang di Five Drink Store--");
                                        System.out.println("> Masukan nama : ");
                                        NamaIn = Input.next();
                                        System.out.println("\n=================");
                                        System.out.println("|   Menu Drink  |");
                                        System.out.println("=================");
                                        System.out.println("| 1. Nescafe    |");
                                        System.out.println("| 2. Milo       |");
                                        System.out.println("| 3. Cocacola   |");
                                        System.out.println("| 4. Fanta      |");
                                        System.out.println("| 5. Sprite     |");
                                        System.out.println("================");
                                        System.out.println("\n> Masukan jumlah minuman : ");
                                        jumlah = Input.nextInt();
                                        System.out.println("> Masukan nomor minuman");
                                        for (int x = 1; x <= jumlah; x++) {
                                            System.out.println("Minuman " + x + " : ");
                                            minuman = Input.nextInt();
                                            switch (minuman) {
                                                case 1:
                                                    if (nescafe.isEmpty() != true) {
                                                        pesanan.add("Nescafe"); // add array pesanan
                                                        System.out.println("Nescafe, code(" + nescafe.pop() + ")");
                                                    } else {
                                                        System.out.println("Maaf Stok Nescafe di store sudah habis");
                                                        System.out.println("Silahkan pilih minuman lain");
                                                    }
                                                    break;
                                                case 2:
                                                    if (milo.isEmpty() != true) {
                                                        pesanan.add("Milo"); // add array pesanan
                                                        System.out.println("Milo, code(" + milo.pop() + ")");
                                                    } else {
                                                        System.out.println("Maaf Stok Milo di store sudah habis");
                                                        System.out.println("Silahkan pilih minuman lain");
                                                    }
                                                    break;
                                                case 3:
                                                    if (cola.isEmpty() != true) {
                                                        pesanan.add("Cocacola"); // add array pesanan
                                                        System.out.println("Cocacola, code(" + cola.pop() + ")");
                                                    } else {
                                                        System.out.println("Maaf Stok Cocacola di store sudah habis");
                                                        System.out.println("Silahkan pilih minuman lain");
                                                    }
                                                    break;
                                                case 4:
                                                    if (fanta.isEmpty() != true) {
                                                        pesanan.add("Fanta"); // add array pesanan
                                                        System.out.println("Fanta, code(" + fanta.pop() + ")");
                                                    } else {
                                                        System.out.println("Maaf Stok Fanta di store sudah habis");
                                                        System.out.println("Silahkan pilih minuman lain");
                                                    }
                                                    break;
                                                case 5:
                                                    if (sprite.isEmpty() != true) {
                                                        pesanan.add("Sprite"); // add array pesanan
                                                        System.out.println("Sprite, code(" + sprite.pop() + ")");
                                                    } else {
                                                        System.out.println("Maaf Stok Sprite di store sudah habis");
                                                        System.out.println("Silahkan pilih minuman lain");
                                                    }
                                                    break;
                                                default:
                                                    System.out.println("Pilihan Minuman tidak ditemukan");
                                                    break;
                                            }
                                        }
                                        System.out.println("\nApakah anda ingin menambah minuman ? (true/false) : ");
                                        pilihan4 = Input.nextBoolean();
                                        System.out.println();
                                    } while (pilihan4);
                                    System.out.println("'''''''''''''''''''''''''''''''''''''''''''");
                                    System.out.println("Hai " + NamaIn);
                                    System.out.println("Pesanan mu : " + pesanan);
                                    System.out.println("Terimakasih sudah mampir ke Five Drink Store");
                                    System.out.println("''''''''''''''''''''''''''''''''''''''''''''");
                                    pesanan.clear();
                                    break;

                                case 2:
                                    System.out.println("\n\n======================================================");
                                    System.out.println("|Stok Minuman di Toko                                |");
                                    System.out.println("======================================================");
                                    System.out.println("|Nescafe  : " + nescafe.size());
                                    System.out.println("|Code     : " + nescafe);
                                    System.out.println("|----------------------------------------------------|");
                                    System.out.println("|Milo     : " + milo.size());
                                    System.out.println("|Code     : " + milo);
                                    System.out.println("|----------------------------------------------------|");
                                    System.out.println("|Cocacola : " + cola.size());
                                    System.out.println("|Code     : " + cola);
                                    System.out.println("|----------------------------------------------------|");
                                    System.out.println("|Fanta    : " + fanta.size());
                                    System.out.println("|Code     : " + fanta);
                                    System.out.println("|----------------------------------------------------|");
                                    System.out.println("|Sprite   : " + sprite.size());
                                    System.out.println("|Code     : " + sprite);
                                    System.out.println("======================================================");

                                    break;
                                default:
                                    System.out.println("Pilihan tidak ditemukan");
                                    break;
                            }
                            System.out.println("\n>> Pilih Menu CUSTOMER Lainnya ? (true/false) : ");
                            pilihan1 = Input.nextBoolean();
                            System.out.println();
                        } while (pilihan1);
                        break;
                }
            } while (finish == -1);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Tree1 tree = new Tree1();
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(1);

        System.out.println("Дерево после добавления:");
        for (Integer i : tree) System.out.print(i + " ");
        System.out.println();

        tree.remove(3);
        System.out.println("Дерево после удаления:");
        for (Integer i : tree) System.out.print(i + " ");
        System.out.println();
    }
}

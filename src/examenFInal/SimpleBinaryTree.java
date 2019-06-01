/**
 *
 * Nombre:  OSCAR ZUNIGA LARA
 * Matricula:   A01654827
 *
 */
package examenFInal;


import java.util.LinkedList;

/**
 * Clase que representa un arbol binario
 *
 * @author Julio Arriaga
 * @param <T>
 */
public class SimpleBinaryTree<T extends Comparable<? super T>> {

    // Clase interna que representa un nodo de un arbol
    // consistente de un dato, un hijo izquierdo y un hijo derecho
    private class TreeNode<T> {

        T data;
        TreeNode<T> right;
        TreeNode<T> left;

        TreeNode() {
            data = null;
            right = null;
            left = null;
        }

        TreeNode(T d) {
            data = d;
            right = null;
            left = null;
        }

        boolean hasLeft() {
            return left != null;
        }

        boolean hasRight() {
            return right != null;
        }

        @Override
        public String toString() {
            return data + " ";
        }
    }

    // Referencia a la raiz del arbol
    private TreeNode<T> root;

    // Constructor que coloca como raiz el
    // parametro recibido
    SimpleBinaryTree(T root) {
        this.root = new TreeNode<>(root);
    }

    // Verifica si el arbol esta vacio o no
    public boolean isEmpty() {
        return root == null;
    }

    // Elimina los datas del arbol
    public void clear() {
        root = null;
    }

    // Inserta el dato child como hijo del dato parent
    // el metodo primero intenta insertar como hijo izquierdo
    // si ya hay un hijo izquierdo, intanta hacerlo como derecho
    // si ya existen ambos, no lo inserta
    public boolean insert(T child, T parent) {
        TreeNode<T> parentNode = find(parent);
        if (parentNode == null) {
            return false;
        }
        if (parentNode.left == null) {
            parentNode.left = new TreeNode<>(child);
        } else if (parentNode.right == null) {
            parentNode.right = new TreeNode<>(child);
        } else {
            return false;
        }
        return true;
    }

    // Encuentra y regresa el TreeNode que contiene a data
    public TreeNode<T> find(T data) {
        if (root == null) {
            return root;
        }
        return findUtil(data, root);
    }

    private TreeNode<T> findUtil(T data, TreeNode<T> node) {
        if (node.data.equals(data)) {
            return node;
        }
        TreeNode<T> l = null;
        TreeNode<T> r = null;
        if (node.left != null) {
            l = findUtil(data, node.left);
        }
        if (node.right != null) {
            r = findUtil(data, node.right);
        }
        if (l != null) {
            return l;
        }
        if (r != null) {
            return r;
        }
        return null;
    }

    // Metodo que regresa una lista con el recorrido EN ORDEN del AB
    public LinkedList<T> inOrder() {
        return inOrderUtil(root, new LinkedList<>());
    }

    // Metodo de utileria para apoyar al metodo inOrden
    private LinkedList<T> inOrderUtil(TreeNode<T> node, LinkedList<T> lst) {
        if (node == null) {
            return lst;
        }
        inOrderUtil(node.left, lst);
        lst.add(node.data);
        inOrderUtil(node.right, lst);
        return lst;
    }

    // Metodo que regresa una lista con el recorrido PRE ORDEN del AB
    public LinkedList<T> preOrder() {
        return preOrderUtil(root, new LinkedList<>());
    }

    // Metodo de utileria para apoyar al metodo PRE ORDEN
    private LinkedList<T> preOrderUtil(TreeNode<T> node, LinkedList<T> lst) {
        if (node == null) {
            return lst;
        }
        lst.add(node.data);
        preOrderUtil(node.left, lst);
        preOrderUtil(node.right, lst);
        return lst;
    }

    // Metodo que regresa una lista con el recorrido POST ORDEN del AB
    public LinkedList<T> postOrder() {
        return postOrderUtil(root, new LinkedList<>());
    }

    // Metodo de utileria para apoyar al metodo POST ORDEN
    private LinkedList<T> postOrderUtil(TreeNode<T> node, LinkedList<T> lst) {
        if (node == null) {
            return lst;
        }
        postOrderUtil(node.left, lst);
        postOrderUtil(node.right, lst);
        lst.add(node.data);
        return lst;
    }

    // Metodo que regresa el total de nodes HOJA en el AB
    public int getNumLeaves() {
        if (isEmpty()) {
            return 0;
        }
        return getNumLeavesUtil(root);
    }

    // Metodo de utileria para apoyar el metodo que regresa el total de
    // nodes HOJA en el AB
    private int getNumLeavesUtil(TreeNode<T> node) {
        if (node.left != null) {
            if (node.right != null) {
                return getNumLeavesUtil(node.left) + getNumLeavesUtil(node.right);
            } else {
                return getNumLeavesUtil(node.left);
            }
        } else if (node.right != null) {
            return getNumLeavesUtil(node.right);
        } else {
            return 1;
        }
    }

    // Metodo que regresa el total de nodes en el AB
    public int getNumNodes() {
        if (isEmpty()) {
            return 0;
        }
        return getNumNodesUtil(root);
    }

    // Metodo de utileria para apoyar el metodo que regresa el total de nodes en
    // el AB
    private int getNumNodesUtil(TreeNode<T> node) {
        if (node.left != null) {
            if (node.right != null) {
                return 1 + getNumNodesUtil(node.left) + getNumNodesUtil(node.right);
            } else {
                return 1 + getNumNodesUtil(node.left);
            }
        } else if (node.right != null) {
            return 1 + getNumNodesUtil(node.right);
        } else {
            return 1;
        }
    }

    // Metodo que regresa TRUE si el data T, del parametro,
    // se encuentra en el AB y FALSE en caso contrario
    public boolean contains(T data) {
        return find(data) != null;
    }

    // Regresa la altura del arbol
    public int height() {
        return nodeHeight(root);
    }

    // Regresa la altura del subarbol con raiz en node
    private int nodeHeight(TreeNode<T> node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        if (node.left != null && node.right != null) {
            return Math.max(1 + nodeHeight(node.left), 1 + nodeHeight(node.right));
        } else if (node.left != null) {
            return 1 + nodeHeight(node.left);
        } else {
            return 1 + nodeHeight(node.right);
        }
    }

    // Implementa este metodo, puedes crear métodos auxiliares si lo necesitas
    public boolean checkBalance() {





        return balanceado(root);
    }


    public boolean balanceado(TreeNode<T> node) {

        if (node.hasLeft() && !node.hasRight()) {
            //System.out.println("TIENE 2 HIJOS");
            return false;
        }
        if (!node.hasLeft() && node.hasRight()){
            return false;
        }


            if (!node.hasRight() && !node.hasLeft()) {
               // System.out.println("NO TIENE NINGUN HIJO");
            }


        if (node.hasLeft())
            return balanceado(node.left);
        if (node.hasRight()){
            return  balanceado(node.right);
        }



        return true;

    }
}

import dsa.iface.IIterator;
import dsa.iface.IPosition;
import dsa.iface.ITree;
import dsa.impl.Tree;

public class Q1<T> {
//   public static int findDepth (ITree < Character > tree, IPosition < Character > tempPosition, Character j,int depth){
//   IIterator<IPosition<Character>> childrenIIterator = tree.children(tempPosition);
//   if (tree.children(tempPosition).hasNext() && tree.children(tempPosition).next().element().equals('j')) {
//      return depth;
//   }
//   else
//      findDepth(tree, (IPosition<Character>) tree.children(childrenIIterator.next()), j, depth + 1);
//   return 0;
//}

   //model
   public static <T> IPosition<T> find(ITree<T> t, IPosition<T> p, T k){
      if(p.element().equals(k)){
         return p;
      }
      IIterator<IPosition<T>> it = t.children(p);
      while(it.hasNext()){
         IPosition<T> childPosition = find(t,it.next(),k);
         if(childPosition != null){
            return childPosition;
         }
      }
      return null;
   }

   //c
   public static <T> int findDepth(ITree<T> t, IPosition<T> p, T k,int depth){
      if(p.element().equals(k)){
         return depth;
      }
      IIterator<IPosition<T>> it = t.children(p);
      while(it.hasNext()){
         int childDepth = findDepth(t,it.next(),k,depth+1);
         if(childDepth != 0){
            return childDepth;
         }
      }
      return -1;
   }

   //C2 by Kelvin qiu
   public static <T> int getDepthOfValue(ITree<T> t, IPosition<T> p) {
      if (t.parent(p) == null) {
         return 0;
      }
      return 1 + getDepthOfValue(t, t.parent(p));
   }



   public static <T> int findHeight(ITree<T> t, IPosition<T> p){
      if(t.isExternal(p))
         return 0;
      int height = 0;
      IIterator<IPosition<T>> it = t.children(p);
      while(it.hasNext()){
         int childHeight = findHeight(t,it.next());
         if(childHeight > height){
            height = childHeight;
         }
      }
      return height + 1;
   }

   public static void main( String[] args ) {
      ITree<Character> tree = Tree.createTreeA();
      // write your code to answer Question 1 here...

      //a
      System.out.println(tree.root().element());

      //b
      IIterator<IPosition<Character>> child = tree.children(tree.root());
      while (child.hasNext()) {
         System.out.print(child.next().element()+" ");
      }
      //c
      System.out.println(findDepth(tree, tree.root(), 'Z',0));
      //d
      System.out.println(findHeight(tree, tree.root()));


      }
   }




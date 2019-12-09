package algorithm;

public class SumOfTwoNumbers
{




    public static ListNode addTwoNumbers( ListNode l1, ListNode l2 )
    {
        ListNode sum = new ListNode( 0 );
        ListNode sumTemp = sum;
        add( l1, l2, 0, sumTemp );
        return rev(sum.next);
    }


   private static ListNode rev( ListNode sum )
    {
        ListNode prev = null;
        ListNode curr = sum;
        ListNode temp = null;
        while(curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            
        }
        return prev;
    }


public static void add( ListNode a, ListNode b, int bal, ListNode sum )
    {
       ListNode tempSum = null;
        if( null == a && null == b )
        {
            if(0 != bal){
                tempSum = new ListNode(bal);
                sum.next = tempSum;
            }
            return;
        }
        else if( null == a )
        {
            sum.next = new ListNode( (b.val + bal)%10 );
            bal = (b.val + bal)/10;
            b = b.next;
        }
        else if( null == b )
        {
            sum.next = new ListNode( (a.val + bal)%10 );
            bal = (a.val + bal)/10;
            a = a.next;
        }
        else
        {
            sum.next = new ListNode( (b.val + a.val + bal) % 10 );
            bal = (b.val + a.val + bal) / 10;
            a = a.next;
            b = b.next;
        }
        add( a, b, bal, sum.next );
    }


    public static void main( String[] args )
    {

        ListNode l1 = new ListNode( 3 );
        ListNode l12 = new ListNode(8);
        ListNode l13 = new ListNode(9);
        l1.next = l12;
        l12.next = l13;
        
        ListNode l2 = new ListNode(0);
        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(9);
        l2.next = l21;
        l21.next = l22;
        
        ListNode list = addTwoNumbers( l1, l2 );
        while(null != list){
            System.out.println( list.val );
            list = list.next;
        }

    }

}

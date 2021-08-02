package solved_problem.leetcode.merge_k_sorted_lists;

import java.util.Comparator;
import java.util.PriorityQueue;


/**
 *
 * 실행 시간 : 10ms (26.92%)
 * 메모리 사용량 : 44.3MB (9.48%)
 *
 * - PriorityQueue를 선언해 우선 순위대로 값을 추가해서 연겷하는 로직
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(l -> l.val));

        ListNode head = new ListNode(0);
        ListNode p = head;

        for (ListNode list : lists) {
            if (list != null)
                queue.offer(list);
        }

        while (!queue.isEmpty()) {
            ListNode n = queue.poll();
            p.next = n;
            p = p.next;

            if (n.next != null)
                queue.offer(n.next);
        }

        return head.next;

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

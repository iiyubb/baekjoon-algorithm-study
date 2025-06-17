package 폰켓몬_이유빈;

import java.util.HashSet;

public class Solution {
  public int solution(int[] nums) {
    int answer = 0;
    int max = nums.length / 2;
    HashSet<Integer> numsSet = new HashSet<>();

    for (int num : nums) {
      numsSet.add(num);
    }

    if (numsSet.size() > max) {
      answer = max;
    } else {
      answer = numsSet.size();
    }
    return answer;
  }
}

package com.revision.topics.greedy.medium.job_sequencing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// pl - https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1
// vl  -https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Greedy/video/OTIz
public class JobSequencing {

    // TODO - Revisit

    /*
Approach: Job Sequencing Problem (Greedy)

1. Each job takes exactly 1 unit of time and must be completed on or before its deadline.
2. To maximize total profit, we should always prioritize jobs with higher profit.

Steps:
1. Create a Job object for each index containing:
   - deadline
   - profit

2. Sort all jobs in descending order of profit.
   - This ensures we always consider the most profitable job first.

3. Find the maximum deadline among all jobs.
   - This determines the number of available time slots.

4. Create a boolean array `slots[]` of size = maxDeadline.
   - slots[i] = true  → time slot i is occupied
   - slots[i] = false → time slot i is free

5. Iterate through each job in sorted order:
   - Try to place the job in the latest available free slot
     that is ≤ (job.deadline - 1).
   - If a free slot is found:
       a) Mark the slot as occupied
       b) Increment job count
       c) Add job's profit to total profit

6. If no free slot is available before the job's deadline,
   skip the job.

7. Return:
   - Total number of jobs done
   - Maximum profit earned

Why Greedy works:
- Choosing the highest profit job first ensures optimal profit.
- Scheduling it as late as possible leaves room for other jobs.

Time Complexity:
- Sorting jobs: O(N log N)
- Scheduling jobs: O(N * maxDeadline) (worst case)
- Overall: O(N log N)

Space Complexity:
- O(N) for jobs and slot array
*/

    public static ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {

        int n = deadline.length;
        Jobs[] jobs = new Jobs[n];

        for (int i = 0; i < n; i++) {
            jobs[i] = new Jobs(deadline[i], profit[i]);
        }

        // 1️⃣ Sort jobs by profit (descending)
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        // 2️⃣ Find max deadline
        int maxDeadline = Arrays.stream(deadline).max().getAsInt();

        // 3️⃣ Slot array (0 = free, 1 = occupied)
        boolean[] slots = new boolean[maxDeadline];

        int count = 0;
        int maxProfit = 0;

        // 4️⃣ Schedule jobs
        for (Jobs job : jobs) {
            // try to place job in latest free slot ≤ deadline
            for (int d = job.deadline - 1; d >= 0; d--) {
                if (!slots[d]) {
                    slots[d] = true;
                    count++;
                    maxProfit += job.profit;
                    break;
                }
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        res.add(count);
        res.add(maxProfit);
        return res;
    }


    public static void main(String[] args) {
        //System.out.println(jobSequencing(new int[]{4, 1, 1, 1}, new int[]{20, 10, 40, 3}));
        System.out.println(jobSequencing(new int[]{2, 1, 2, 1, 1}, new int[]{100, 19, 27, 25, 15}));
        //System.out.println(jobSequencing(new int[]{3, 1, 2, 2}, new int[]{50, 10, 20, 30}));
    }
}

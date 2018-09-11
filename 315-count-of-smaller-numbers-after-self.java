

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        return solveMerge(nums);
    }

    ///////////////////////////////////////////////
    // merge sort O(nlogn)
    
    private List<Integer> solveMerge(int[] nums) {
        List<MergeItem> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            list.add(new MergeItem(i, num));
        }

        merge(list, 0, nums.length - 1);

        Collections.sort(list, (a, b) -> (a.i - b.i));

        List<Integer> ret = new ArrayList<>();
        for (MergeItem e: list) {
            ret.add(e.inversion);
        }
        return ret;
    }

    private void merge(List<MergeItem> list, int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;

        merge(list, left, mid);
        merge(list, mid+1, right);

        // merge two sides
        List<MergeItem> merged = new ArrayList<>();

        int inversion = 0;
        int p = left, q = mid + 1;
        while (p <= mid && q <= right) {
            MergeItem pe = list.get(p);
            MergeItem qe = list.get(q);

            if (pe.val <= qe.val) {
                pe.inversion += inversion;
                merged.add(pe);
                p++;
            } else {
                inversion += 1;
                merged.add(qe);
                q++;
            }
        }

        while (p <= mid) {
            MergeItem pe = list.get(p);
            pe.inversion += inversion;
            merged.add(pe);
            p++;
        }
        while (q <= right) {
            MergeItem qe = list.get(q);
            merged.add(qe);
            q++;
        }

        // modify original list
        for (int i = 0; i < merged.size(); i++) {
            list.set(left+i, merged.get(i));
        }
    }

    private class MergeItem {
        int i, val;
        int inversion;

        MergeItem(int i, int val) {
            this.i = i; this.val = val; inversion = 0;
        }
    }
}

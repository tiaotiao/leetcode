

class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        if (paths.length == 0) return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        for (String s : paths) {
            String[] ss = s.split(" ");
            String dir = ss[0];
            for (int i = 1; i < ss.length; i++) {
                String fs = ss[i];
                int lb = fs.indexOf('(');
                int rb = fs.indexOf(')');
                String name = fs.substring(0, lb);
                String content = fs.substring(lb + 1, rb);
                String path = dir + "/" + name;

                List<String> list = map.getOrDefault(content, new ArrayList<>());
                list.add(path);
                map.put(content, list);
            } 
        }

        List<List<String>> res = new ArrayList<>();
        for (String key : map.keySet()) {
            List<String> list = map.get(key);
            if (list.size <= 1) continue;
            res.add(list);
        }
        return res;
    }
}
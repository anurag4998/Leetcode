
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
        recursion(root, 0 , 0, map);
        List<List<Integer>> result = new ArrayList<>();
        for(Map.Entry<Integer, TreeMap<Integer, List<Integer>>> entry : map.entrySet()) {
            List<Integer> hLvlNodes = new ArrayList<>();
            TreeMap<Integer, List<Integer>> hMap = entry.getValue();
            for(Map.Entry<Integer, List<Integer>> vMap : hMap.entrySet()) {
                List<Integer> nodes = vMap.getValue();
                if(nodes.size() > 1) {
                    Collections.sort(nodes);
                }
                hLvlNodes.addAll(nodes);
            }
            result.add(hLvlNodes);
        }
        return result;
    }

    private void recursion(TreeNode root, int hLvl, int vLvl, TreeMap<Integer, TreeMap<Integer, List<Integer>>> map)
    {
        if(root == null) {
            return;
        }

        if(map.containsKey(hLvl)) {
            TreeMap<Integer, List<Integer>> innerMap = map.get(hLvl);
            if(innerMap.containsKey(vLvl)) {
                List<Integer> list = innerMap.get(vLvl);
                list.add(root.val);
            }
            else {
                List<Integer> tempList = new ArrayList<>();
                tempList.add(root.val);
                innerMap.put(vLvl, tempList);
            }
        }
        else {
            //store the node against the horizontal and vertical levels
            TreeMap<Integer, List<Integer>> innerMap = new TreeMap<>();
            List<Integer> li = new ArrayList<>();
            li.add(root.val);
            innerMap.put(vLvl, li);
            map.put(hLvl, innerMap);
        }

        recursion(root.left, hLvl - 1, vLvl + 1, map);
        recursion(root.right, hLvl + 1, vLvl + 1, map);
    }
}
package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> account2Name = new HashMap<>();
        FindUnion findUnion = new FindUnion(accounts);
        List<List<String>> results = new ArrayList<>();

        for (List<String> account : accounts) {
            int i = 2;
            String name = account.get(0);
            String father = account.get(1);
            account2Name.put(father, name);
            while (i < account.size()) {
                if (i != 1) {
                    findUnion.union(father, account.get(i));
                }

                i++;
            }
        }

        for (String father : account2Name.keySet()) {
            if (findUnion.isFather(father)) {
                List<String> children = findUnion.getChild(father);
                children.sort(String::compareTo);
                String name = account2Name.get(father);
                List<String> result = new ArrayList<>();
                result.add(name);
                result.addAll(children);
                results.add(result);
            }
        }

        return results;
    }


    private class FindUnion {
        Map<String, String> father = new HashMap<>();

        public FindUnion(List<List<String>> accounts) {
            for (List<String> account : accounts) {
                for (int i = 1; i < account.size(); i++) {
                    String currentAccount = account.get(i);
                    this.father.put(currentAccount, currentAccount);
                }
            }
        }

        public String findFather(String child) {
            if (this.father.get(child).equals(child)) {
                return child;
            } else {
                String father = findFather(this.father.get(child));
                this.father.put(child, father);
                return father;
            }
        }

        public void union(String father, String child) {
            this.father.put(findFather(child), findFather(father));
        }

        public List<String> getChild(String father) {
            List<String> children = new ArrayList<>();

            for (String child : this.father.keySet()) {
                if (findFather(child).equals(father)) {
                    children.add(child);
                }
            }

            return children;
        }

        private boolean isFather(String current) {
            return this.findFather(current).equals(current);
        }
    }
}

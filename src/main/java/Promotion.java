import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@EqualsAndHashCode
public class Promotion {
    private Set<String> groups = new HashSet<>();

    public void addGroup(String group) {
        groups.add(group);
    }

    public Set<String> getGroups() {
        return new HashSet<>(groups);
    }
}

package domain;

import utils.SplitUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Names {
    private static final String DEFAULT_DELIMITER = ",";

    private final List<Name> names;

    public Names(String names) {
        this(SplitUtils.split(names, DEFAULT_DELIMITER)
                .stream()
                .map(Name::new)
                .collect(Collectors.toList()));
    }

    public Names(List<Name> names) {
        this.names = new ArrayList<>(names);
    }

    public List<Name> list() {
        return Collections.unmodifiableList(names);
    }
}

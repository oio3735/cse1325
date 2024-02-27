package store;

public enum Exposure {
    SHADE,PARTSUN, SUN;

    @Override
    public String toString() {
        switch(this) {
            case SHADE:
                return "part sun / part shade";
            case PARTSUN:
                return "part sun";
            case SUN:
                return "full sun";
            default:
                return "Unknown";
        }
    }
}
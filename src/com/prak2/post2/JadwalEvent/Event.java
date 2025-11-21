//package com.prak2.post2.JadwalEvent;

public class Event {
    private String title;
    private Waktu start; // komposisi objek
    private Waktu end;   // komposisi objek

    // Static counter untuk total event
    private static int totalEvents = 0;

    // TODO: static getter getTotalEvents()
    public static int getTotalEvents() {
        return totalEvents;
    }

    // ========== CONSTRUCTORS (OVERLOADING) ==========

    // TODO: Constructor default
    //  - title = "Untitled"
    //  - start = 00:00
    //  - end   = 00:00
    //  - tingkatkan totalEvents
    public Event() {
        this.title = "Untitled";
        this.start = new Waktu();
        this.end = new Waktu();
        totalEvents++;
    }

    // TODO: Constructor Event(String title, Waktu start, Waktu end)
    public Event(String title, Waktu start, Waktu end) {
        if (title == null || title.equals("")) {
            this.title = "Untitled";
        } else {
            this.title = title;
        }
        if (start == null) {
            this.start = new Waktu();
        } else {
            this.start = new Waktu(Waktu.toMinutes(start));
        }
        if (end == null) {
            this.end = new Waktu();
        } else {
            this.end = new Waktu(Waktu.toMinutes(end));
        }
        totalEvents++;
    }

    // TODO: Constructor Event(String title, int sh, int sm, int eh, int em)
    public Event(String title, int sh, int sm, int eh, int em) {
        if (title == null || title.equals("")) {
            this.title = "Untitled";
        } else {
            this.title = title;
        }
        this.start = new Waktu(sh, sm);
        this.end = new Waktu(eh, em);
        totalEvents++;
    }

    // TODO: Constructor Event(String title, Waktu start, int durationMin)
    public Event(String title, Waktu start, int durationMin) {
        if (title == null || title.equals("")) {
            this.title = "Untitled";
        } else {
            this.title = title;
        }
        if (start == null) {
            this.start = new Waktu();
        } else {
            this.start = new Waktu(Waktu.toMinutes(start));
        }
        this.end = Waktu.addMinutes(this.start, durationMin);
        totalEvents++;
    }

    // TODO: Getter getTitle(), getStart(), getEnd()
    public String getTitle() {
        return this.title;
    }
    public Waktu getStart() {
        return new Waktu(Waktu.toMinutes(this.start));
    }
    public Waktu getEnd() {
        return new Waktu(Waktu.toMinutes(this.end));
    }

    // TODO: static boolean isOverlap(Event a, Event b)
    public static boolean isOverlap(Event a, Event b) {
        int sa = Waktu.toMinutes(a.start);
        int ea = Waktu.toMinutes(a.end);
        int sb = Waktu.toMinutes(b.start);
        int eb = Waktu.toMinutes(b.end);

        return (sa < eb && sb < ea); 
    }

    @Override
    public String toString() {
        // TODO: kembalikan string
        return this.title + " [" + start.toString() + "-" + end.toString() + "] (tz: " + Waktu.getDefaultTz() + ")";
    }
}

package detail_tracker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

@Entity
@Table(name = "Room")
public class Room {

    public enum RoomType {
        BASEMENT,
        BATHROOM,
        BEDROOM,
        CRAWLSPACE,
        DINING_ROOM,
        ENTRY,
        GARAGE,
        GUEST_BEDROOM,
        KITCHEN,
        LAUNDRY_ROOM,
        LIVING_ROOM,
        LOFT,
        MUDROOM,
        NOOK,
        OFFICE,
        OTHER,
        PRIMARY_BATHROOM,
        PRIMARY_BEDROOM,
        STORAGE,
        SUNROOM,
        UTILITY_ROOM,
        WALK_IN_CLOSET
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id", nullable = false, unique = true)
    private Integer roomId;

    @ManyToOne
    @JoinColumn(name = "floor_id", nullable = false)
    private Floor floor;

    @Enumerated(EnumType.STRING)
    @Column(name = "room_type", nullable = false)
    private RoomType roomType;

    @Column(name = "room_name", nullable = false, length = 100, columnDefinition = "varchar(100) default 'n/a'")
    private String roomName = "n/a";

    @Column(name = "arch_code", nullable = false, length = 20, columnDefinition = "varchar(20) default 'n/a'")
    private String archCode = "n/a";

    // getters and setters
    // ...
}
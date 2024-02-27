package detail_tracker.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "plumbing_fixture_lkp")
public class PlumbingFixtureLkp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plumbing_fixture_id", nullable = false)
    private int plumbingFixtureId;

    @Column(name = "fixture_type", nullable = false)
    private String fixtureType;

    // getters and setters
    public int getPlumbingFixtureId() {
        return plumbingFixtureId;
    }

    public void setPlumbingFixtureId(int plumbingFixtureId) {
        this.plumbingFixtureId = plumbingFixtureId;
    }

    public String getFixtureType() {
        return fixtureType;
    }

    public void setFixtureType(String fixtureType) {
        this.fixtureType = fixtureType;
    }
}

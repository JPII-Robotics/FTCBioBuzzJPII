# BIOBUZZ (FTC 2026-2027) - Game Summary and Strategy

A working summary of the game for the programming and build teams. It is deliberately high level.

> **Read this first.** This was compiled in November 2026 from web search summaries of the
> Competition Manual and community sites, not from the manual itself. Point values and thresholds
> change in Team Updates. Anything marked *(verify)* came from a third-party source. The official
> Competition Manual on firstinspires.org always wins over this file.

## The game in one paragraph

Two alliances (red and blue) of two robots each play on a standard 12 ft x 12 ft FTC field. Robots
collect two kinds of scoring elements, POLLEN and NECTAR, and score them by **launching** them
into their alliance's HIVE, or by **placing** them in FLOWERS and GARDENS. Filling a HIVE enough
makes it TIP, which is the single biggest scoring event. The match ends with robots PARKING.

## Match flow

| Period     | Length | Notes                                                         |
|------------|--------|---------------------------------------------------------------|
| AUTO       | 0:30   | No driver input at all. Robots run pre-programmed code.       |
| Transition | 0:08   | Drivers pick up controllers; field is scored for AUTO.        |
| TELEOP     | 2:00   | Driver controlled. The last 60 seconds unlock extra options.  |

## Scoring elements

- **POLLEN** - plastic balls about 3 in. in diameter, similar to last season's DECODE artifacts.
  There are a lot of them on the field *(about 40 - verify)*. Each alliance pre-loads some
  *(4 per alliance side - verify how they split between robots)*.
- **NECTAR** - a second element, larger and heavier than POLLEN *(verify size)*, in alliance
  colors. Most NECTAR starts **off the field** and is only allowed in at certain times (see
  below). It is worth more toward tipping the HIVE than a POLLEN is.

## Field elements

- **HIVE** - a large structure at the center of the field. Each alliance has one. It sits on a
  pivot and has two CELLS; one CELL faces upward at a time. Robots launch elements into the
  upward CELL. When enough weight is in it, the HIVE TIPS and the other CELL comes up.
- **CELLS** - the containers on the HIVE. Each has a cluster of four small AprilTags (36h11
  family, 3.25 in.) on its bottom face, intended for robot navigation and aiming. Tag IDs are
  different for red and blue *(34-37 red, 38-41 blue - verify)*.
- **FLOWERS** - four of them, mounted on the field walls, roughly 21 in. tall at the top ring.
  Elements are placed (not launched) into them. Both alliances can score in a FLOWER and fight
  over who owns it.
- **GARDENS** - low-value scoring areas for elements *(verify exact location and definition)*.
- **LOADING ZONE** - a small alliance-specific area (roughly 23 in. x 11 in.) next to the
  alliance's human players. NECTAR enters the field here, and robots PARK here at the end.

## How points are scored

Values below are from community sources and were consistent across several of them, but
**verify against Table 10-2 of the current manual.**

| Action                                                   | Points          |
|----------------------------------------------------------|-----------------|
| LEAVE (robot moves off the perimeter wall in AUTO)       | 3               |
| HIVE TIP (AUTO or TELEOP)                                | 20              |
| Each element left in the upward CELL at match end        | 2               |
| Each element in a FLOWER your alliance owns              | 2               |
| Bottom-NECTAR bonus in a FLOWER                          | 5               |
| Each element in a GARDEN                                 | 1               |
| PARK (robot at least partly in LOADING ZONE at end)      | 5               |

Key mechanics:

- **Tipping is weight-based, not count-based.** A HIVE tips after a certain combination of
  elements; NECTAR counts for more than POLLEN. Community estimates put a tip at roughly 7-8
  POLLEN-equivalents *(unofficial)*.
- **NECTAR is gated.** An alliance may bring in one NECTAR per HIVE TIP, and all remaining NECTAR
  in the last 60 seconds. Humans cannot hand elements to a robot directly but can roll NECTAR to
  it through the LOADING ZONE. Bringing NECTAR in early is a foul.
- **FLOWER ownership** goes to the alliance whose NECTAR is on top. NECTAR may not go into a
  FLOWER before the last 60 seconds; POLLEN can go in at any time.
- **Do not launch elements out of the field** on purpose - it is a penalty.

## Ranking points

Besides winning (3) or tying (1) *(verify)*, alliances can earn bonus ranking points:

- **SWARM** - combined LEAVE + PARK points reach a threshold *(16 at lower-level events -
  verify)*. In practice: both robots leave in AUTO and both park at the end.
- **POLLINATOR 1 / POLLINATOR 2** - the alliance reaches a number of HIVE TIPS
  *(4 and 7 - verify)*.

Thresholds are higher at higher-level events.

## What this means for our robot (software view)

- Launching into the HIVE is the core scoring action, and the CELL AprilTags exist to help aim.
- AUTO is 30 seconds with pre-loaded POLLEN: a LEAVE is nearly free points, and launching
  pre-loads starts progress toward the first tip.
- PARK needs the robot to reliably get to a small zone at the end of the match.
- The target moves: after a TIP the other CELL is the one facing up.

---

## Our strategy

*To be filled in by the team after studying the scoring in the Competition Manual. Leave blank
until then.*

### Scoring priorities

- What gives the most points per second for a robot like ours?
- What will we deliberately **not** do?

### Autonomous

- Starting position(s):
- Minimum goal:
- Stretch goal:

### TeleOp

- Main scoring cycle (where we collect, where we shoot from):
- Role of driver 1:
- Role of driver 2:
- NECTAR plan / human player plan:

### Last 60 seconds and PARK

- When do we stop cycling and go park?
- FLOWERS: do we contest them?

### Ranking points we are targeting

-

### Working with an alliance partner

- What we tell our partner we can do:
- What we ask a partner to cover:

### Open questions to answer from the manual

-

## Sources

- Official Competition Manual and Team Updates: https://ftc-resources.firstinspires.org/ftc/game/cm-html
- FIRST game and season page: https://www.firstinspires.org/programs/ftc/game-and-season
- Game postcard: https://www.firstinspires.org/hubfs/web/program/ftc/biobuzz-gamepostcard.pdf
- Season guidance (FTC Penn): https://www.ftcpenn.org/wp-content/uploads/2026-2027-Season-Guidance-Bee-in-the-Know.pdf
- Studica strategy overview: https://www.studica.co/ftc-biobuzz-strategy-starter-bot
- BIOBUZZ Strategy Lab (community): https://biobuzz-strategy-lab.com/guide/

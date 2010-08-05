// ~/Downloads/UMLGraph-5.3/bin/umlgraph Behavior svg

interface IBehavior {}
    abstract class Behavior implements IBehavior {}
        abstract class Eat extends Behavior {}
            class SheepEat extends Eat {}
            class WolfEat  extends Eat {}
        abstract class Move extends Behavior {}
            class SheepMove extends Move {}
            class WolfMove  extends Move {}
        abstract class Reproduce extends Behavior {}
            class GrassReproduce extends Reproduce {}
            class SheepReproduce extends Reproduce {}
            class WolfReproduce  extends Reproduce {}

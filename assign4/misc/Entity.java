// ~/Downloads/UMLGraph-5.3/bin/umlgraph Entity svg

interface IEntity {}
    abstract class Entity implements IEntity {}
        class Fence extends Entity {}
        class Grass extends Entity {}
        class Sheep extends Entity {}
        class Wolf  extends Entity {}

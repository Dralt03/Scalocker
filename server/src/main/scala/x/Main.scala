package x

case class Build (
    base: Build.Base,
    commands: List[Command],
)

object Build{
    enum Base{
        case Empty,
        case Hash(hash: x.Hash)
    }
}

enum Command{ 
    case Upsert(key:String, value: String)
    case Delete(key:String)
}

case class Hash(value: Array[Byte])
class Person() {
    var name: String = ""
    get()= "Name : "+field
    var age: Int = 0
    set(age){field =+1}
}

fun main() {

    var person: Person = Person()
    this.name = "Mike"
    this.age = 20

    person.run {
        name = "Mike"
        age = 20

        set(30)
    }
    println(person.get())
}
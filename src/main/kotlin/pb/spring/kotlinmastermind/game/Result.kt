package pb.spring.kotlinmastermind.game

class Result(val valuePoints: Int, val positionPoints: Int) {

    override fun toString(): String {
        return "Result(valuePoints=$valuePoints, positionPoints=$positionPoints)"
    }
}
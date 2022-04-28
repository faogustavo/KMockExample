package dev.valvassori.kmockexample

class ViewModel constructor(
    private val repository: Repository,
    private val mobileRepository: MobileRepository,
) {
    fun getData(): String {
        val repoValue = repository.getSomeData()
        return mobileRepository.doSomethingWith(repoValue)
    }
}

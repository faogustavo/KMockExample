package dev.valvassori.kmockexample

import tech.antibytes.kmock.MockCommon
import tech.antibytes.kmock.MockShared
import kotlin.test.Test
import kotlin.test.assertEquals

@MockCommon(Repository::class)
@MockShared("mobileTest", MobileRepository::class)
class ViewModelTest {

    private val repository = kmock<RepositoryMock>()
    private val mobileRepository = kmock<MobileRepositoryMock>()
    private val subject by lazy { ViewModel(repository, mobileRepository) }

    @Test
    fun rebuildTest() {
        assertEquals(4, 2 + 2)
    }
}

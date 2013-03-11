package example.infrastructure.util

/**
 * テストの記述を容易にするための Groovy 拡張モジュール。
 */
class TestExtension {
    /**
     * オブジェクトのフィールド値の一覧を Map 形式で返す。
     * @param self
     * @return
     * @see http://codereview.stackexchange.com/questions/8801/returning-groovy-class-fields-as-a-map
     */
    static Map asMap(Object self) {
        self.class.declaredFields.findAll { !it.synthetic }.collectEntries {
            [ it.name, self."$it.name" ]
        }
    }

    /**
     * オブジェクトのフィールド値の一覧を、指定されたフィールドに限定して Map 形式で返す。
     * @param self
     * @param fields
     * @return
     */
    static Map asMap(Object self, String... fields) {
        self.class.declaredFields.findAll { !it.synthetic && fields.contains(it.name) }.collectEntries {
            [ it.name, self."$it.name" ]
        }
    }
}

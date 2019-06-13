Sample project to demonstrate issue with Espresso's `typeText()` on Robolectric

When using Espresso's `typeText()` api on an `EditText` with `inputType="number"`, the text remains empty.

The same problem was corrected already for `inputType="phone"`: https://github.com/robolectric/robolectric/issues/4149

Steps to reproduce:

Run `./gradlew testDebugUnitTest cAT`

Expected behavior: the `ExampleEspressoTest.tesEnterText()` test passes both as a `test` test and an `androidTest` test.
Actual behavior: the test passes as an `androidTest` test but fails as a `test` test:

```
androidx.test.espresso.base.DefaultFailureHandler$AssertionFailedWithCauseError: 'with text: is "1234"' doesn't match the selected view.
Expected: with text: is "1234"
     Got: "AppCompatEditText{id=2131165238, res-name=edittext, visibility=VISIBLE, width=320, height=58, has-focus=true, has-focusable=true, has-window-focus=true, is-clickable=true, is-enabled=true, is-focused=true, is-focusable=true, is-layout-requested=false, is-selected=false, layout-params=androidx.constraintlayout.widget.ConstraintLayout$LayoutParams@6d88ed95, tag=null, root-is-layout-requested=false, has-input-connection=true, editor-info=[inputType=0x2 imeOptions=0x6 privateImeOptions=null actionLabel=null actionId=0 initialSelStart=0 initialSelEnd=0 initialCapsMode=0x0 hintText=null label=null packageName=null fieldId=0 fieldName=null extras=null hintLocales=null contentMimeTypes=null ], x=0.0, y=178.0, text=, input-type=2, ime-target=false, has-links=false}"
```

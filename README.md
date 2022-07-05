# Passphrase
*Password Generator for Android Apps*

**Add it to your root build.gradle**
```
    allprojects {
        repositories {
            ...
            maven {
                url 'https://jitpack.io'
            }
        }
    }
```

**Add the dependency to app build.gradle**
```
    dependencies {
        implementation 'com.github.nevidelia:Passphrase:1.0.0'
    }
```

**How it works?**
```
    Passphrase passphrase = new Passphrase();
```

**Customize passphrase**
```
    // set length
    passphrase.setLength(20);
    
    // set lower case characters
    passphrase.setLowers(true);
    
    // set uppercase characters
    passphrase.setUppers(true);
    
    // set numbers
    passphrase.setNumbers(true);
    
    // set separators
    passphrase.setSeparators(true);
```

**Generate passphrase**
```
    // String key = passphrase.render();
```

**License**
```
    Copyright 2022 Nevidelia Inc.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
```
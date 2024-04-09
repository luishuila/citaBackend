package com.barberia.citaShow;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.barberia.citaShow", importOptions = ImportOption.DoNotIncludeTests.class)

public class pruebaLayou {

    static final String CONTROLLERS_PACKAGE = "..controller..";
    @ArchTest
    static final ArchRule controllers_should_be_suffixed =
            classes()
                    .that()
                    .resideInAPackage(CONTROLLERS_PACKAGE)
                    .should()
                    .haveSimpleNameEndingWith("Controller")
                    .because("Controllers must be named with Controller suffix");
}

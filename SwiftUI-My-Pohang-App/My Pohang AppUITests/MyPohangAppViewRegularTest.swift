//
//  MyPohangAppViewRegular.swift
//  My Pohang AppUITests
//
//  Created by Jaehwa Noh on 12/23/23.
//

import XCTest

final class MyPohangAppViewRegularTest: XCTestCase {

    var app: XCUIApplication?
    
    override func setUpWithError() throws {
        // Put setup code here. This method is called before the invocation of each test method in the class.

        // In UI tests it is usually best to stop immediately when a failure occurs.
        continueAfterFailure = false

        // In UI tests it’s important to set the initial state - such as interface orientation - required for your tests before they run. The setUp method is a good place to do this.
        app = XCUIApplication()
        XCUIDevice.shared.orientation = .landscapeLeft
        app?.launch()
    }

    override func tearDownWithError() throws {
        // Put teardown code here. This method is called after the invocation of each test method in the class.
        try super.tearDownWithError()
        app = nil
    }

    func test_RegularDevice_CategoryView_VerifyContent() throws {
        openSidebarWithCount(app: app!, count: 1)
        let categoryCoffeeButton = app!.buttons["카페"]
        XCTAssertTrue(categoryCoffeeButton.exists)
    }
    
    func test_RegularDevice_ClickCategory_ShowRecommendView() throws {
        openSidebarWithCount(app: app!, count: 1)
        navigateRecommend(app: app!)
        let recommendButton = app!.buttons["러블랑"]
        XCTAssertTrue(recommendButton.exists)
    }
    
    func test_RegularDevice_ClickRecommend_ShowRecommendDetailView() throws {
        openSidebarWithCount(app: app!, count: 1)
        navigateRecommendDetail(app: app!)
        let informationText = app!.staticTexts["Information"]
        XCTAssertTrue(informationText.exists)
    }
}

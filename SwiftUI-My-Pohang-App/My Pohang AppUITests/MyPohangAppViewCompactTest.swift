//
//  MyPohangAppViewTest.swift
//  My Pohang AppUITests
//
//  Created by Jaehwa Noh on 12/23/23.
//

import XCTest

final class MyPohangAppViewCompactTest: XCTestCase {

    var app: XCUIApplication?
    
    override func setUpWithError() throws {
        try super.setUpWithError()
        // Put setup code here. This method is called before the invocation of each test method in the class.

        // In UI tests it is usually best to stop immediately when a failure occurs.
        continueAfterFailure = false

        // In UI tests it’s important to set the initial state - such as interface orientation - required for your tests before they run. The setUp method is a good place to do this.
        app = XCUIApplication()
        app?.launch()
    }

    override func tearDownWithError() throws {
        // Put teardown code here. This method is called after the invocation of each test method in the class.
        try super.tearDownWithError()
        app = nil
    }

    func test_CompactDevice_CategoryView_VerifyContent() throws {
        let categoryCoffeeButton = app!.buttons["카페"]
        XCTAssertTrue(categoryCoffeeButton.exists)
    }
    
    func test_CompactDevice_ClickCategory_ShowRecommendView() throws {
        navigateRecommend(app: app!)
        let recommendButton = app!.buttons["러블랑"]
        XCTAssertTrue(recommendButton.exists)
    }
    
    func test_CompactDevice_ClickRecommend_ShowRecommendDetailView() throws {
        navigateRecommendDetail(app: app!)
        let informationText = app!.staticTexts["Information"]
        XCTAssertTrue(informationText.exists)
    }
}

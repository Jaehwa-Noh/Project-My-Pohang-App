//
//  ContentView.swift
//  My Pohang App
//
//  Created by Jaehwa Noh on 12/22/23.
//

import SwiftUI

struct MyPohangApp: View {
    var body: some View {
        NavigationSplitView {
            Text("Split1")
        } content: {
            Text("Split2")
        } detail: {
            Text("Split3")
        }

    }
}

#Preview {
    MyPohangApp()
}
